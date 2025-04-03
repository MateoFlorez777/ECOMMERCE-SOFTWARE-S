package com.softwares.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.softwares.domain.USER_ROLE;
import com.softwares.models.User;
import com.softwares.repository.UserRepository;

public class CustomUserServiceImpl implements UserDetailsService{

    private UserRepository userRepository;
    private static final String SELLER_PREFIX="seller_";
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.startsWith(SELLER_PREFIX)) {

        }else{
            User user = userRepository.findByEmail(username);
            if(user!=null) {
                return buildUserDetails(user.getEmail(),user.getPassword(),user.getRole());
            }
        }
        return null;
    }

    private UserDetails buildUserDetails(String email, String password, USER_ROLE role) {

        return null;
    }

}
