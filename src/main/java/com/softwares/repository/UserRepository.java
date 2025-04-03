package com.softwares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwares.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
}
