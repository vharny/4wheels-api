package com.wheels.wheelsapi.controller;

import com.wheels.wheelsapi.dto.ProductDto;
import com.wheels.wheelsapi.entity.Product;
import com.wheels.wheelsapi.service.ProductService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(value = "Product", tags = {"Product"})
@RequestMapping(path = "product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private ProductService service;
    private ModelMapper modelMapper;

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

    @GetMapping("provider/{id}")
    public List<Product> getProductsByProviderId(@PathVariable Integer id) {
        return service.getProductsByProviderId(id);
    }

    @GetMapping("category/{id}")
    public List<Product> getProductsByCategoryId(@PathVariable Integer id) {
        return service.getProductsByCategoryId(id);
    }

    @GetMapping("description")
    public List<Product> getProductsByDescription(@RequestHeader String description) {
        return service.getProductsByDescription(description);
    }

    @GetMapping("search")
    public List<Product> getProductsByProviderAndCategoryAndDescription(@RequestHeader Integer provider, @RequestHeader Integer category, @RequestHeader String description) {
        return service.getProductsByProviderAndCategoryAndDescription(provider, category, description);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Product createProduct(@RequestBody ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return service.createProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public Product updateProduct(@RequestBody ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return service.updateProduct(product);
    }
}