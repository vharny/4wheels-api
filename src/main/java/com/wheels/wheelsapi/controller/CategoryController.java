package com.wheels.wheelsapi.controller;

import com.wheels.wheelsapi.entity.Category;
import com.wheels.wheelsapi.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(value = "Category", tags = {"Category"})
@RequestMapping(path = "category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }
}
