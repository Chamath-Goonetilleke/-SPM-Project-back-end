package com.SPM.backend.IT20122096.TripPlaning.Controller;

import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Entity.TripPlan;
import com.SPM.backend.IT20122096.TripPlaning.Service.TripPlanService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TripPlanController {

    private final TripPlanService tripPlanService;

    public TripPlanController(TripPlanService tripPlanService) {
        this.tripPlanService = tripPlanService;
    }

    @GetMapping("/tripPlan/{tripId}")
    public ResponseEntity getTripPlanById(@PathVariable ObjectId tripId) {
        return tripPlanService.getTripPlanById(tripId);
    }

    @GetMapping("/tripPlan/getAll/{userId}")
    public ResponseEntity getAllTripPlans(@PathVariable ObjectId userId) {
        return tripPlanService.getAllTripPlans(userId);
    }

    @PostMapping("/tripPlan/save")
    public ResponseEntity saveTripPlan(@RequestBody TripPlan tripPlan) {
        return tripPlanService.saveTripPlan(tripPlan);
    }

    @PutMapping("/tripPlan/{tripId}")
    public ResponseEntity updateTripPlanById(@PathVariable ObjectId tripId) {
        return tripPlanService.getTripPlanById(tripId);
    }

    @GetMapping("/tripPlan/delete/{tripId}")
    public ResponseEntity deleteTripPlanById(@PathVariable ObjectId tripId) {
        return tripPlanService.deleteTripPlanById(tripId);
    }
    @PostMapping("/tripPlan/pay")
    public ResponseEntity payForTripPlan(@RequestBody PaymentDTO paymentDTO) {
        return tripPlanService.payForTripPlan(paymentDTO);
    }
}
