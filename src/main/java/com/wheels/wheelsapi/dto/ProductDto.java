package com.wheels.wheelsapi.dto;

import com.wheels.wheelsapi.entity.Category;
import com.wheels.wheelsapi.entity.Provider;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    Integer id;
    String name;
    float price;
    String description;
    int stock;
    Category category;
    Provider provider;
    String handle;
}
