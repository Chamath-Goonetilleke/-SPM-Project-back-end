package com.SPM.backend.IT20122096.TripPlaning.Controller;

import com.SPM.backend.IT20122096.TripPlaning.Entity.TripPlan;
import com.SPM.backend.IT20122096.TripPlaning.Service.TripPlanService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripPlanController {

    private final TripPlanService tripPlanService;

    public TripPlanController(TripPlanService tripPlanService) {
        this.tripPlanService = tripPlanService;
    }

    @PostMapping("/tripPlan/save")
    public ResponseEntity saveTripPlan(@RequestBody TripPlan tripPlan){
        return tripPlanService.saveTripPlan(tripPlan);
    }
    @GetMapping("/tripPlan/getAll/{userId}")
    public ResponseEntity getAllTripPlans(@PathVariable ObjectId userId){
        return tripPlanService.getAllTripPlans(userId);
    }
}
