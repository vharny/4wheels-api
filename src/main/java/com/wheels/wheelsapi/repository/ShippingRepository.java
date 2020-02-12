package com.wheels.wheelsapi.repository;

import com.wheels.wheelsapi.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer>{
}
