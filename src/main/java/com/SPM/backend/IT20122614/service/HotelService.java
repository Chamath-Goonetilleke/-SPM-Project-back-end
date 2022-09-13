package com.SPM.backend.IT20122614.service;

import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {


    private final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void addNewHotel(Hotel hotel){
        hotelRepository.insert(hotel);
    }


    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
