package com.wheels.wheelsapi.controller;

import com.wheels.wheelsapi.dto.ProductDto;
import com.wheels.wheelsapi.entity.Provider;
import com.wheels.wheelsapi.service.ProviderService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(value = "Provider", tags = {"Provider"})
@RequestMapping(path = "provider", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {
    private ProviderService service;

    @Autowired
    public ProviderController(ProviderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return service.getAllProviders();
    }

    @GetMapping("{id}")
    public Optional<Provider> getProviderbyID(@PathVariable Integer id) {
        return service.getProviderById(id);
    }

    @PostMapping
    public Provider createProvider(@RequestBody ProductDto providerDto) {
        ModelMapper modelMapper = new ModelMapper();
        Provider provider = modelMapper.map(providerDto, Provider.class);
        return service.createProduct(provider);
    }
}
