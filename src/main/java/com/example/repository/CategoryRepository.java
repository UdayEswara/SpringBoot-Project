package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>
{

}
