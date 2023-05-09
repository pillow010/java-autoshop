package com.automotoshop.Service;

import com.automotoshop.Repository.UserRepository;
import com.automotoshop.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 A service class that implements Spring Security's UserDetailsService interface
 to load user-specific data for authentication.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     Constructor for the UserDetailsServiceImpl class.
     @param userRepository the repository for user entities.
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     Loads the user details object by the given username.
     @param username the username of the user to be loaded.
     @return the user details object containing user-specific data for authentication.
     @throws UsernameNotFoundException if no user is found with the given username.
     */
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> user = Optional.ofNullable (userRepository.findByUsername (username));
            return user.map(u -> new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
                    new ArrayList<> ())).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        }

}

