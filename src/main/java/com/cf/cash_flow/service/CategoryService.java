package com.cf.cash_flow.service;

import com.cf.cash_flow.model.Category;
import com.cf.cash_flow.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        if(categoryRepository.existsByCategoryNameAndUserId(category.getName(), category.getUser().getId())) {
            throw new RuntimeException("Category already exists by category name and user id.");
        }
        return categoryRepository.save(category);
    }

    public Category getById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = null;

        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        } else {
            throw new RuntimeException("Category not found by id: " + id);
        }
        return category;
    }

    public List<Category> getByName(String categoryName) {
        return categoryRepository.findByCategoryNameContainingIgnoreCase(categoryName);
    }

    public List<Category> getByUserId(Long userId) {
        return categoryRepository.findByUserId(userId);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}