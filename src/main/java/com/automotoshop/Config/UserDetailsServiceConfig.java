package com.automotoshop.Config;

import com.automotoshop.Repository.UserRepository;
import com.automotoshop.Service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceConfig {

    private final UserRepository userRepository;

    public UserDetailsServiceConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // create and return the user details service bean
        return new UserDetailsServiceImpl (userRepository);
    }
}

