package com.example.hotel.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String username;
    private Long hotelId;
    private Integer roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    // Конструкторы
    public Booking() {
    }

    public Booking(String email, String username, Long hotelId, Integer roomNumber, 
                  LocalDate checkInDate, LocalDate checkOutDate) {
        this.email = email;
        this.username = username;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Геттеры
    public Long getId() {
        return id;
    }

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
    public void setId(Long id) {
        this.id = id;
    }

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

    // Методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id != null && id.equals(booking.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // Метод toString
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", hotelId=" + hotelId +
                ", roomNumber=" + roomNumber +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
} 