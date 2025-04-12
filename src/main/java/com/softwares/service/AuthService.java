package com.softwares.service;

import com.softwares.request.LoginRequest;
import com.softwares.response.AuthResponse;
import com.softwares.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email) throws Exception;
    String createUser(SignupRequest req) throws Exception;
    AuthResponse signing(LoginRequest req);
}
