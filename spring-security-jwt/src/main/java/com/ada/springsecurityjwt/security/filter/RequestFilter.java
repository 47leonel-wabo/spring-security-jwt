package com.ada.springsecurityjwt.security.filter;

import com.ada.springsecurityjwt.security.configs.JwtUtil;
import com.ada.springsecurityjwt.security.configs.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {

    private final JwtUtil mJwtUtil;
    private final UserDetailsServiceImpl mUserDetailsService;

    @Autowired
    public RequestFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        mJwtUtil = jwtUtil;
        mUserDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        // First grab the 'Authorization' field from request header
        final String authHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        // Make sure it's not null
        if (authHeader != null && authHeader.startsWith("Bearer ")){
            jwtToken = authHeader.substring(7);
            username = this.mJwtUtil.extractUsername(jwtToken);
        }

        // Make sure that user is not yet into the security context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.mUserDetailsService.loadUserByUsername(username);

            // Check if the username matches and jwt token is not expired
            if (this.mJwtUtil.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
        }
        filterChain.doFilter(request, response);
    }
}
