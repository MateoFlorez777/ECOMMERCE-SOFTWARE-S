package com.softwares.request;

import java.util.List;

import lombok.Data;

@Data
public class CreateProductRequest {
    
    private String tittle;
    private String description;
    private int mrpPrice;
    private int sellingPrice;
    private String color;
    private List<String> images;
    private String category;
    private String category2;
    private String category3;
    private String sizes;
}
