package com.wheels.wheelsapi.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Provider {
    @Id
    @GeneratedValue
    Integer id;
    String denomination;
    String siret;
    String address;
    String firstName;
    String lastName;
}
