package com.example.admin_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AdminServiceApplication {
    @RestController
    @RequestMapping("/api")
    class ApiController {

        @GetMapping
        public String getAPI() {
            return "API is working!";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

}
