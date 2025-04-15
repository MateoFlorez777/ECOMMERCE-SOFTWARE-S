package com.softwares.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.softwares.exceptions.ProductException;
import com.softwares.models.Product;
import com.softwares.models.Seller;
import com.softwares.request.CreateProductRequest;

public interface ProductService {

    public Product createProduct(CreateProductRequest req, Seller seller);
    public void deleteProduct(Long productId) throws ProductException;
    public Product updateProduct(Long productId,Product product) throws ProductException;
    Product findProductById(Long productId) throws ProductException;
    List<Product> searchProducts(String query);
    public Page<Product> getAllProducts(
            String category,
            String brand,
            String colors,
            String sizes,
            Integer minPrice,
            Integer maxPrice,
            Integer minDiscount,
            String sort,
            String stock,
            Integer pageNumber

    );

    List<Product> getProductBySellerId(Long sellerId);

}
