package com.wheels.wheelsapi.service.impl;

import com.wheels.wheelsapi.entity.Shipping;
import com.wheels.wheelsapi.repository.ShippingRepository;
import com.wheels.wheelsapi.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {
    private ShippingRepository repository;

    @Autowired
    public ShippingServiceImpl(ShippingRepository repository) { this.repository = repository; }

    @Override
    public List<Shipping> getAllShippings() { return repository.findAll(); }
}
