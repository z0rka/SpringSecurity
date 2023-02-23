package com.example.springsecurity;

import com.example.springsecurity.model.UserRole;
import com.example.springsecurity.service.ProductService;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringSecurityApplication {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {//Method to add user with role admin and user with default role for access test

        userService.addUser("Admin", "qwerty", UserRole.ADMIN);

        userService.addUser("User", "ytrewq", UserRole.DEFAULT);

        productService.add("Iphone", 1000.0f);
    }
}
