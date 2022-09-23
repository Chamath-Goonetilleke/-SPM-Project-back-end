package com.SPM.backend.IT20122614.service;

import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public Hotel getHotelsById(String name){
        Hotel hotels = hotelRepository.findHotelById(name);
        return hotels;
    }

    public void updateHotelDetails(String id, Hotel hotel) {
//        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Hotel hotelOne = hotelRepository.findHotelById(id);
        hotelOne.setName(hotel.getName());
        hotelOne.setType(hotel.getType());
        hotelOne.setDescription(hotel.getDescription());
        hotelOne.setAddress(hotel.getAddress());
        hotelOne.setCity(hotel.getCity());
        hotelOne.setImageURL(hotel.getImageURL());
        hotelOne.setRoom(hotel.getRoom());

        hotelRepository.save(hotelOne);

    }

    public void deleteHotelDetails(String name) {

        hotelRepository.deleteHotelById(name);
    }
}
