package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/health")
    public String health() {
        return "Hello & Welcome to CloudKatha !!!";
    }
}
