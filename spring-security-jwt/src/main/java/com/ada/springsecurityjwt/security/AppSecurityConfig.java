package com.ada.springsecurityjwt.security;

import com.ada.springsecurityjwt.security.configs.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl mUserDetailsService;

    @Autowired
    public AppSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        mUserDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mUserDetailsService);
    }

    /*
        As we use a hard coded user detail no need for valid password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
