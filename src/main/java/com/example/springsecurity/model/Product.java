package com.example.springsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity for table Product
 *
 * @author z0rka 13.02.2023
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "my_app")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private float cost;
}
