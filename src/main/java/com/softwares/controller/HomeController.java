package com.softwares.controller;

import org.springframework.web.bind.annotation.RestController;

import com.softwares.response.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {

    @GetMapping
    public ApiResponse HomeControllerHandler(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Bienvenidos a Software-S");
        
        return apiResponse;
    }
    
}
