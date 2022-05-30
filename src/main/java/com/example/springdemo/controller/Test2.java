package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2 {
    @GetMapping("/test-2")
    public String health() {
        return "Hello & Welcome Test 2!!!";
    }
}
