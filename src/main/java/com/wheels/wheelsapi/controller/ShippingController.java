package com.wheels.wheelsapi.controller;


import com.wheels.wheelsapi.entity.Shipping;
import com.wheels.wheelsapi.service.ShippingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(value = "Shipping", tags = {"Shipping"})
@RequestMapping(path = "shipping", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShippingController {
    private ShippingService service;

    @Autowired
    public ShippingController(ShippingService service) { this.service = service; }


    @GetMapping
    public List<Shipping> getAllShippings() { return service.getAllShippings(); }
}
