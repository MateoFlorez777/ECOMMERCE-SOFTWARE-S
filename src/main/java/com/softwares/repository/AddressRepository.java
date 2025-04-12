package com.softwares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwares.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
