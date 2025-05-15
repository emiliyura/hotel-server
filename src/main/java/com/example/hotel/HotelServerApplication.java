package com.example.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.hotel.model")
@EnableJpaRepositories("com.example.hotel.repository")
public class HotelServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelServerApplication.class, args);
    }
} // пйоследний комит