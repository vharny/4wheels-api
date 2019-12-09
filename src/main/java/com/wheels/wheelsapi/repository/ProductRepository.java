package com.wheels.wheelsapi.repository;

import com.wheels.wheelsapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProvider_Id(Integer id);
    List<Product> findByCategory_Id(Integer id);
    List<Product> findByDescriptionContains(String description);
    List<Product> findByProvider_IdAndCategory_IdAndDescriptionContains(Integer provider, Integer category, String description);
}