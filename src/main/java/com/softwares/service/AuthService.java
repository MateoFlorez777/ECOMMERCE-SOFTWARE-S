package com.softwares.service;

import com.softwares.response.SignupRequest;

public interface AuthService {

    String createUser(SignupRequest req);
}
