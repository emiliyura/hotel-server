package com.example.hotel.service; //lol

import com.example.hotel.model.Booking;
import com.example.hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public java.util.List<Booking> getBookingsByUsername(String username) {
        return bookingRepository.findAllByUsername(username);
    }
} 