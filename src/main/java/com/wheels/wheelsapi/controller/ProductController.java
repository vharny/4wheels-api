package com.wheels.wheelsapi.controller;

import com.wheels.wheelsapi.entity.Product;
import com.wheels.wheelsapi.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Product", tags = {"Product"})
@RequestMapping(path = "product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return service.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }
}