package com.softwares.service;

import com.softwares.domain.USER_ROLE;
import com.softwares.request.LoginRequest;
import com.softwares.response.AuthResponse;
import com.softwares.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email,USER_ROLE role) throws Exception;
    String createUser(SignupRequest req) throws Exception;
    AuthResponse signing(LoginRequest req);
}
