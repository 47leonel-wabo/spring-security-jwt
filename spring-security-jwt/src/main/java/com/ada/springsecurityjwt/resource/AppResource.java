package com.ada.springsecurityjwt.resource;

import com.ada.springsecurityjwt.domain.AuthenticationRequest;
import com.ada.springsecurityjwt.domain.AuthenticationResponse;
import com.ada.springsecurityjwt.security.configs.JwtUtil;
import com.ada.springsecurityjwt.security.configs.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AppResource {

    private final AuthenticationManager mAuthenticationManager;
    private final UserDetailsServiceImpl mUserDetailsService;
    private final JwtUtil mJwtUtil;

    @Autowired
    public AppResource(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtil) {
        mAuthenticationManager = authenticationManager;
        mUserDetailsService = userDetailsService;
        mJwtUtil = jwtUtil;
    }

    @GetMapping(path = "/hello")
    public String sayHello() {
        return "Hello there!";
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) {
        mAuthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword())
        );
        final UserDetails userDetails = mUserDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = mJwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
