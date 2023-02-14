package com.example.springsecurity.service;

import com.example.springsecurity.dto.UserInfoDto;
import com.example.springsecurity.model.UserInfo;
import com.example.springsecurity.model.UserRole;
import com.example.springsecurity.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author z0rka 13.02.2023
 * Service for UserRepository
 */
@Service
@RequiredArgsConstructor
@Slf4j

public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * Method to parse User to UserDTO
     */
    private UserInfoDto parseUser(UserInfo user) {
        return objectMapper.convertValue(user, UserInfoDto.class);
    }

    /**
     * Method to add user
     *
     * @param name-    name
     * @param password - password
     * @param role     - role
     */
    public void addUser(String name, String password, UserRole role) {
        log.info("Adding user method invoked");

        if (name == null || password == null || role == null) {
            log.error("Parameter is null");
            return;
        }

        UserInfo user = new UserInfo();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        userRepository.save(user);

        log.info("Adding user method ended");
    }

    /**
     * Method to delete user by id
     *
     * @param id - users id
     */
    public void deleteUser(int id) {
        log.info("Deleting user method invoked");
        userRepository.deleteById(id);
        log.info("Deleting user method ended");
    }

    /**
     * Method to get  user by id
     *
     * @param id - users id
     * @return UserDto
     */
    public UserInfoDto getUserById(int id) {
        Optional<UserInfo> user = userRepository.findById(id);
        return parseUser(user.orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    /**
     * Method to get all users
     *
     * @return List<UserDto>
     */
    public List<UserInfoDto> getAll() {
        List<UserInfo> allUsers = userRepository.findAll();
        return allUsers.stream().map(this::parseUser).toList();
    }

    /**
     * Method to get  user by name
     *
     * @param name- users name
     * @return UserDto
     */
    public UserInfoDto getByName(String name) {
        Optional<UserInfo> user = userRepository.findFirstByName(name);
        return parseUser(user.orElseThrow(() -> new EntityNotFoundException("User not found")));
    }
}
