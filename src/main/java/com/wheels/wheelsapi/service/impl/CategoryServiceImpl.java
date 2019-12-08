package com.wheels.wheelsapi.service.impl;

import com.wheels.wheelsapi.entity.Category;
import com.wheels.wheelsapi.repository.CategoryRepository;
import com.wheels.wheelsapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return repository.findById(id);
    }
}
