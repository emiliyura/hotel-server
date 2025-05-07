package com.example.hotel.controller;

import com.example.hotel.dto.AuthToken;
import com.example.hotel.dto.LoginRequest;
import com.example.hotel.dto.RegisterRequest;
import com.example.hotel.model.Token;
import com.example.hotel.model.User;
import com.example.hotel.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthToken> register(@RequestBody RegisterRequest request) {
        Token token = authService.register(request);
        return ResponseEntity.ok(new AuthToken(token.getToken()));
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
} 