package com.wheels.wheelsapi.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shipping")
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shipping {
    @Id
    @GeneratedValue
    Integer id;
    @JoinColumn
    @OneToOne
    Product product;
    @Column(name = "date_send")
    Date dateSend;
    @JoinColumn
    @OneToOne
    User users;
}
