package com.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author z0rka 13.02.2023
 * Login controller for users
 */
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {
    /**
     * Login page
     */
    @GetMapping("")
    public String login() {
        log.info("Login page");
        return "login";
    }
}
