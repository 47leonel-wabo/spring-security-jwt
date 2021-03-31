package com.ada.springsecurityjwt.security.configs;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /*
        This will return a hard coded user details
        but in a real scenario, user is fetched from real database based on username
        passed as argument to this method
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("ada", "ada", Collections.emptyList());
    }
}
