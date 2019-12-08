package com.wheels.wheelsapi.service;

import com.wheels.wheelsapi.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Integer id);
}
