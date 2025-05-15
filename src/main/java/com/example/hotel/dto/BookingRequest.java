package com.example.hotel.dto;

import java.time.LocalDate;

public class BookingRequest {
    private String email;
    private String username;
    private Long hotelId;
    private Integer roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    // Геттеры
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    // Сеттеры
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
} 