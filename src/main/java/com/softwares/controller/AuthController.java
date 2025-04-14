package com.softwares.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwares.domain.USER_ROLE;
import com.softwares.models.VerificationCode;
import com.softwares.repository.UserRepository;
import com.softwares.request.LoginOtpRequest;
import com.softwares.request.LoginRequest;
import com.softwares.response.ApiResponse;
import com.softwares.response.AuthResponse;
import com.softwares.response.SignupRequest;
import com.softwares.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req) throws Exception{

        String jwt=authService.createUser(req);

        AuthResponse res=new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("register success");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);

        return ResponseEntity.ok(res);
    }

    @PostMapping("/sent/login-signup-otp")
    public ResponseEntity<ApiResponse> sentOtpHandler(@RequestBody LoginOtpRequest req) throws Exception{

        authService.sentLoginOtp(req.getEmail(),req.getRole());

        ApiResponse res=new ApiResponse();

        res.setMessage("otp sent sucessfully");

        return ResponseEntity.ok(res);
        
    }


    @PostMapping("/signing")
    public ResponseEntity<AuthResponse> LoginHandler(@RequestBody LoginRequest req) throws Exception{

        AuthResponse authResponse=authService.signing(req);


        return ResponseEntity.ok(authResponse);
        
    }

   
}