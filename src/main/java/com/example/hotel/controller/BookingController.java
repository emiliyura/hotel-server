package com.example.hotel.controller;

import com.example.hotel.dto.BookingRequest;
import com.example.hotel.model.Booking;
import com.example.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;
    
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {
        Booking booking = new Booking();
        booking.setEmail(request.getEmail());
        booking.setUsername(request.getUsername());
        booking.setHotelId(request.getHotelId());
        booking.setRoomNumber(request.getRoomNumber());
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }
} 