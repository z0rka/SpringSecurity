package com.example.springsecurity.controller;

import com.example.springsecurity.dto.UserInfoDto;
import com.example.springsecurity.model.UserRole;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for {@link com.example.springsecurity.service.UserService}
 *
 * @author z0rka 23.02.2023
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    /**
     * Add user to DB
     *
     * @param userName - login of the user
     * @param password - password of the user
     * @param role     - role of the user
     */
    @PostMapping("")
    public void addUser(@RequestParam String userName, @RequestParam String password, @RequestParam UserRole role) {
        log.info("Add user method invoked");

        userService.addUser(userName, password, role);

        log.info("Add user method ended");
    }

    /**
     * Get user by id
     *
     * @param id - id of the user in DB
     * @return {@link UserInfoDto}
     */
    @GetMapping("{id}")
    public UserInfoDto getUser(@PathVariable int id) {
        log.info("Get user method invoked");

        return userService.getUserById(id);
    }

    /**
     * Get all users
     *
     * @return List of {@link UserInfoDto}
     */
    @GetMapping("")
    public List<UserInfoDto> getUsers() {
        log.info("Get users method invoked");

        return userService.getAll();
    }

    /**
     * Delete user
     *
     * @param id - if of the user to delete
     */

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id) {
        log.info("Delete user method invoked");

        userService.deleteUser(id);

        log.info("Delete user method ended");
    }

}
