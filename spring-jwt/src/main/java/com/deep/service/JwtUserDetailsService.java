package com.deep.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if("Deep".equalsIgnoreCase(userName)) {
            return new User("Deep", "$2a$10$6rA6yp/DBx0s7T1gXNAF/e133oxsZtRexllTB54bhC5GD3WeXaUBy",
                    new ArrayDeque<>());
        }
        throw new UsernameNotFoundException("User not found with username : " + userName);
    }
}
