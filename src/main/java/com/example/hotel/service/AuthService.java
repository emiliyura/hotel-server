package com.example.hotel.service;

import com.example.hotel.dto.LoginRequest;
import com.example.hotel.dto.RegisterRequest;
import com.example.hotel.model.User;
import com.example.hotel.model.Token;
import com.example.hotel.repository.UserRepository;
import com.example.hotel.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    
    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }
    
    public Token register(RegisterRequest request) {
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Username is required");
        }
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email is required");
        }
        if (!isValidEmail(request.getEmail())) {
            throw new RuntimeException("Invalid email format");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        
        user = userRepository.save(user);

        // Генерация токена
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setToken(tokenValue);
        token.setUser(user);
        tokenRepository.save(token);

        return token;
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    
    public User login(LoginRequest request) {
        return userRepository.findByUsername(request.getUsername())
            .filter(user -> 
                user.getPassword().equals(request.getPassword()) ||
                passwordEncoder.matches(request.getPassword(), user.getPassword())
            )
            .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }
} 