package com.springrest.service;

import com.springrest.entity.UserInfo;
import com.springrest.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = userRepository.findById(1).get();
        if (user == null) {
            
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return User.builder().username(user.getEmail()).password(user.getPassword()).build();
    }
}