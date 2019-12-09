package com.wheels.wheelsapi.service;

import com.wheels.wheelsapi.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);
    List<Product> getProductsByProviderId(Integer id);
    List<Product> getProductsByCategoryId(Integer id);
    List<Product> getProductsByDescription(String description);
    List<Product> getProductsByProviderAndCategoryAndDescription(Integer provider, Integer category, String description);
    Product createProduct(Product product);
    Product updateProduct(Integer id, Product product);
}
