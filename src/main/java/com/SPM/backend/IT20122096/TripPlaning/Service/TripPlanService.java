package com.SPM.backend.IT20122096.TripPlaning.Service;

import com.SPM.backend.IT20122096.TripPlaning.Entity.TripPlan;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface TripPlanService {

    ResponseEntity saveTripPlan(TripPlan tripPlan);
    ResponseEntity getAllTripPlans(ObjectId userId);
}
