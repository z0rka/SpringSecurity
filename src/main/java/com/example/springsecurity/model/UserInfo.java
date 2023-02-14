package com.example.springsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author z0rka 13.02.2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "my_app")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
