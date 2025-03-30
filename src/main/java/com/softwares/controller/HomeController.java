package com.softwares.controller;

import org.springframework.web.bind.annotation.RestController;

import com.softwares.response.ApiResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
//http://localhost:8080/home/
@RequestMapping("/home")
@CrossOrigin(value = "http://localhost:3000")

public class HomeController {

    @GetMapping("/welcome")
    public ApiResponse HomeControllerHandler () {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Bienvenidos a mi ecommerce");
        return apiResponse;
    }

}
