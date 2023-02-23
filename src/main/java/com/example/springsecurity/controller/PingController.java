package com.example.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to check if server is up
 *
 * @author z0rka 13.02.2023
 */
@RestController
@RequestMapping("/ping")
@Slf4j
public class PingController {

    /**
     * Ping window
     *
     * @return String "OK"
     */
    @GetMapping("")
    public String ping() {
        log.info("Ping method invoked");
        return "OK";
    }
}
