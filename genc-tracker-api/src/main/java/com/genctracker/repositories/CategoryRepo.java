package com.genctracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genctracker.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
