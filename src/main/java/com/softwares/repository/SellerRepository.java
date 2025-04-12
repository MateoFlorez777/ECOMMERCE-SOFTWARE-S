package com.softwares.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwares.models.Seller;
import com.softwares.domain.AccountStatus;


public interface SellerRepository extends JpaRepository<Seller,Long>{

    Seller findByEmail(String email);
    List<Seller> findByAccountStatus(AccountStatus status);
}
