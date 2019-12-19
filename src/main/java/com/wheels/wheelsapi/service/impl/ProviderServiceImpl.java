package com.wheels.wheelsapi.service.impl;

import com.wheels.wheelsapi.entity.Provider;
import com.wheels.wheelsapi.repository.ProviderRepository;
import com.wheels.wheelsapi.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository repository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Provider> getAllProviders() {
        return repository.findAll();
    }

    @Override
    public Optional<Provider> getProviderById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Provider createProduct(Provider provider) {
        return repository.save(provider);
    }
}
