package com.wheels.wheelsapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProviderDto {
    String denomination;
    String siret;
    String address;
    String firstName;
    String lastName;
}
