package com.wheels.wheelsapi.service.impl;

import com.wheels.wheelsapi.entity.Product;
import com.wheels.wheelsapi.repository.ProductRepository;
import com.wheels.wheelsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product prod = repository.findById(id).get();
        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        prod.setStock(product.getStock());
        return repository.save(prod);
    }
}
