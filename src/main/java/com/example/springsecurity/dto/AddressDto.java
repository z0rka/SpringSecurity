package com.example.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author z0rka 23.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;

    private UserInfoDto userInfo;

    private String country;

    private String city;

    private String street;

    private String house;
}
