package com.example.springsecurity.dto;


import com.example.springsecurity.model.UserInfo;
import com.example.springsecurity.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author z0rka 13.02.2023
 * User DTO for class {@link UserInfo}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private Integer id;

    private String name;

    private String password;

    private UserRole role;
}
