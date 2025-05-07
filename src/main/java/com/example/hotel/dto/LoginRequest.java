package com.example.hotel.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

    // Геттеры
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Сеттеры
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 