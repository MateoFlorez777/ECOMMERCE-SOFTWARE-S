package com.softwares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwares.models.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{

    Seller findByEmail(String email);
}
