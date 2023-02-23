package com.example.springsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author z0rka 23.02.2023
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "my_app")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "fk_user_info_id")
    private UserInfo userInfo;

    private String country;

    private String city;

    private String street;

    private String house;
}