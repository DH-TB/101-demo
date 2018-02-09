package com.example.repository;

import com.example.entity.Category;
import com.example.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
}
