package com.wheels.wheelsapi.controller;

import com.wheels.wheelsapi.entity.Provider;
import com.wheels.wheelsapi.service.ProviderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return service.createProduct(provider);
    }
}
