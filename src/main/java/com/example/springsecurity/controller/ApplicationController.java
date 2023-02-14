package com.example.springsecurity.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

/**
 * @author z0rka 13.02.2023
 * Controller of the basic windows
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    /**
     * Open basic window with time
     */
    @GetMapping("info")
    public String info(Model model) {
        model.addAttribute("currentDate", LocalDate.now().toString());
        model.addAttribute("data", "System time millis:" + System.currentTimeMillis());
        return "basicWindow";
    }

    /**
     * Open basic window
     */
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("currentDate", LocalDate.now().toString());
        model.addAttribute("data", "Welcome");
        return "basicWindow";
    }

    /**
     * Open error
     */
    @GetMapping("403")
    public String error403() {
        return "/error/403";
    }
}
