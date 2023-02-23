package com.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for errors
 *
 * @author z0rka 23.02.2023
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ErrorController {
    /**
     * Open error
     *
     * @return error window
     */
    @GetMapping("403")
    public String error403() {
        return "/error/403";
    }
}
