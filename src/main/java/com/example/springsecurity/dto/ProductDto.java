package com.example.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product DTO to convert {@link com.example.springsecurity.model.Product}
 *
 * @author z0rka 13.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private float cost;
}
