package com.wheels.wheelsapi.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "product")
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    float price;
    String description;
    int stock;
    @JoinColumn
    @OneToOne
    Category category;
    @JoinColumn
    @OneToOne
    Provider provider;
    String handle;
}
