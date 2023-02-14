package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z0rka 13.02.2023
 * Controller to check if serveris up
 */
@RestController
@RequestMapping("/ping")
@Slf4j
public class PingController {

    /**
     * Ping window
     */
    @GetMapping("")
    public String ping() {
        log.info("Ping method invoked");
        return "OK";
    }
}
