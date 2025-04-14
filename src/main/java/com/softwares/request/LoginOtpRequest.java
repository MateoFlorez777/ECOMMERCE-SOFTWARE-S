package com.softwares.request;

import com.softwares.domain.USER_ROLE;

import lombok.Data;

@Data          
public class LoginOtpRequest {

    private String email;
    private String opt;
    private USER_ROLE role;
}
                