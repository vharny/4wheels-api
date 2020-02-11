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
    public List<Product> getProductsByProviderId(Integer id) {
        return repository.findByProvider_Id(id);
    }

    @Override
    public List<Product> getProductsByCategoryId(Integer id) {
        return repository.findByCategory_Id(id);
    }

    @Override
    public List<Product> getProductsByDescription(String description) {
        return repository.findByDescriptionContains(description);
    }

    @Override
    public List<Product> getProductsByProviderAndCategoryAndDescription(Integer provider, Integer category, String description) {
        return repository.findByProvider_IdAndCategory_IdAndDescriptionContains(provider, category, description);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productOptional = repository.findById(product.getId());
        if (productOptional.isPresent()) {
            Product productUpdate = productOptional.get();
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setStock(product.getStock());
            productUpdate.setCategory(product.getCategory());
            productUpdate.setProvider(product.getProvider());
            productUpdate.setHandle(product.getHandle());
            return repository.save(productUpdate);
        }
        return product;
    }
}
