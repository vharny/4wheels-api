package com.wheels.wheelsapi.service;

import com.wheels.wheelsapi.entity.Provider;

import java.util.List;
import java.util.Optional;

public interface ProviderService {
    List<Provider> getAllProviders();
    Optional<Provider> getProviderById(Integer id);
    Provider createProduct(Provider provider);
}
