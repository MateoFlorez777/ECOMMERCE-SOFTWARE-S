package com.softwares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwares.models.Cart;

public interface  CartRepository extends JpaRepository<Cart,Long> {

}
