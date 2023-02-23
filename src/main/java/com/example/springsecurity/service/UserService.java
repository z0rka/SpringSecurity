package com.example.springsecurity.service;

import com.example.springsecurity.dto.UserInfoDto;
import com.example.springsecurity.model.UserInfo;
import com.example.springsecurity.model.UserRole;
import com.example.springsecurity.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for UserRepository
 *
 * @author z0rka 13.02.2023
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
     *
     * @param user - user from database
     * @return {@link UserInfoDto} - parsed user
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
    @Transactional
    public void addUser(String name, String password, UserRole role) {
        log.info("Adding user method invoked");

        if (name == null || password == null || role == null) {
            log.error("Parameter is null");
            return;
        } else if (userRepository.findFirstByName(name).isPresent()) {
            log.error("User with such name already exists!");
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
    @Transactional
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
