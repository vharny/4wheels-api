package com.wheels.wheelsapi.service;

import com.wheels.wheelsapi.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);
    Product addProduct(Product product);
    Product updateProduct(Integer id, Product product);
}
