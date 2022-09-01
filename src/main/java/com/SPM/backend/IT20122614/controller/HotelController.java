package com.SPM.backend.IT20122614.controller;

import com.SPM.backend.IT20122614.DTO.HotelDTO;
import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    HotelService hotelService;

    @PostMapping("/add-new")
    public ResponseEntity<?> addNewHotel(@RequestBody HotelDTO hotel){
        System.out.println("testttttttttttt" + hotel);

        try{
            int isInserted = hotelService.insertNewHotel(hotel);
            return ResponseEntity.ok(isInserted);

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Insert new Hotel");
        }

    }
}
