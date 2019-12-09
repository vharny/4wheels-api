package com.wheels.wheelsapi.service;

import com.wheels.wheelsapi.entity.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();
    Provider createProduct(Provider provider);
}
