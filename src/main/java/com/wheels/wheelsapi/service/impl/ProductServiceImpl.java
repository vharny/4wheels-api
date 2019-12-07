package com.wheels.wheelsapi.service.impl;

import com.wheels.wheelsapi.entity.Product;
import com.wheels.wheelsapi.repository.ProductRepository;
import com.wheels.wheelsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        System.out.print("testhdddhhh");
        return repository.findAll();
    }
}
