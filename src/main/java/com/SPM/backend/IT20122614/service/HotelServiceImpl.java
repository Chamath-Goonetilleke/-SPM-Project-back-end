package com.SPM.backend.IT20122614.service;

import com.SPM.backend.IT20122614.DTO.HotelDTO;
import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public int insertNewHotel(HotelDTO hotel) {
        Hotel hotels = new Hotel(hotel.getType(), hotel.getName(), hotel.getDescription(), hotel.getAddress(), hotel.getCity(), hotel.getImageURL(), hotel.getRoomType(), hotel.getFacilities(), hotel.getPrice());

        hotelRepository.save(hotels);

        return 1;
    }
}
