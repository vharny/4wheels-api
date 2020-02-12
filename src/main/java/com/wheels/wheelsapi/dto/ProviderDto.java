package com.wheels.wheelsapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProviderDto {
    Integer id;
    String denomination;
    String address;
    String siret;
    String firstName;
    String lastName;
}
