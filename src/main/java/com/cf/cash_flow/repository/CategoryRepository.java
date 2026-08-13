package com.cf.cash_flow.repository;


import com.cf.cash_flow.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);
    List<Category> findByUserId(Long userId);
    boolean existsByCategoryNameAndUserId(String categoryName, Long userId);
}