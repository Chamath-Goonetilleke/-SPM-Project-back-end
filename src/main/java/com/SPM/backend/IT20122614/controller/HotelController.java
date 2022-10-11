package com.SPM.backend.IT20122614.controller;

import com.SPM.backend.IT20122614.DTO.HotelDTO;
import com.SPM.backend.IT20122614.model.Expense;
import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.service.ExpenseService;
import com.SPM.backend.IT20122614.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin("*")
public class HotelController {

    private final HotelService hotelService;
    private final ExpenseService expenseService;

    public HotelController(HotelService hotelService, ExpenseService expenseService) {
        this.hotelService = hotelService;
        this.expenseService = expenseService;
    }

    @PostMapping("/add-new")
    public ResponseEntity<?> addNewHotel(@RequestBody Hotel hotel){

        try{
            hotelService.addNewHotel(hotel);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Insert new Hotel");
        }

    }
    @GetMapping("/display")
    public ResponseEntity<?> display(){
        return ResponseEntity.ok(hotelService.getAllHotels());

    }
    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/edit/{name}")
    public ResponseEntity<?> getSingleEditDetails(@PathVariable String name) {
        return ResponseEntity.ok(hotelService.getHotelsById(name));
    }
    @PostMapping("/update-hotel/{name}")
    public ResponseEntity<?> updateHotelDetails(@RequestBody Hotel hotel, @PathVariable String name) {

         hotelService.updateHotelDetails(name, hotel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable String id){

        System.out.println("delete" + id);
        hotelService.deleteHotelDetails(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();


    }


}
