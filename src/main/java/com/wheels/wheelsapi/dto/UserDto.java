package com.wheels.wheelsapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    String lastName;
    String firstName;
    String email;
    boolean admin;
}
