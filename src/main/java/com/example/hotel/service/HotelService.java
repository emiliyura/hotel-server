package com.example.hotel.service;

import com.example.hotel.model.Hotel;
import com.example.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {
    
    private final HotelRepository hotelRepository;
    private final String uploadDir = "uploads/hotels";
    
    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
        try {
            Files.createDirectories(Paths.get(uploadDir));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать директорию для загрузки", e);
        }
    }
    
    public Hotel saveHotel(String name, Double pricePerNight, String description, 
                          Integer roomCount, MultipartFile imageFile) throws IOException {
        
        String imageUrl = null;
        if (imageFile != null && !imageFile.isEmpty()) {
            imageUrl = saveImage(imageFile);
        }
        
        Hotel hotel = new Hotel(name, pricePerNight, description, roomCount, imageUrl);
        return hotelRepository.save(hotel);
    }
    
    private String saveImage(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path targetPath = Paths.get(uploadDir, filename);
        Files.copy(file.getInputStream(), targetPath);
        return "/api/hotels/images/" + filename;
    }
    
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }
} 