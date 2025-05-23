package com.softwares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwares.models.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryId(String categoryId);

    List<Category>findByLevel(Integer level);
}
