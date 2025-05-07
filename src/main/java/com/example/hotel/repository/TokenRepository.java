package com.example.hotel.repository;

import com.example.hotel.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    boolean existsByToken(String token);
} 