package com.softwares.service.impl;

import org.springframework.stereotype.Service;

import com.softwares.config.JwtProvider;
import com.softwares.models.User;
import com.softwares.repository.UserRepository;
import com.softwares.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email=jwtProvider.getEmailFromJwtToken(jwt);

        return this.findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        User user=userRepository.findByEmail(email);

        if(user==null) {
            throw new Exception("user not found with email - " + email);
        }
        return user;
    }

}
