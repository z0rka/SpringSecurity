package com.example.springsecurity.security;

import com.example.springsecurity.dto.UserInfoDto;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * Class for security user creation
 *
 * @author z0rka 13.02.2023
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    /**
     * Load user from database by his username and formatting him into User from spring security
     * @param username - login of the user
     * @return {@link UserDetails}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoDto userDto = userService.getByName(username);

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + userDto.getRole().name()));
        return new User(userDto.getName(), userDto.getPassword(), roles);
    }
}
