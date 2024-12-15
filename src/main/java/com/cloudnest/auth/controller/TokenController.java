package com.cloudnest.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/api/v1")
public class TokenController {

    @GetMapping("/token")
    public String generateToken() {
        return new String(Base64.getEncoder().encode("Hello".getBytes()));
    }
}
