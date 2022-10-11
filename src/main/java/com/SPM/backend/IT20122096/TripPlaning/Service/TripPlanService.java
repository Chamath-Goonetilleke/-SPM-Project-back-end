package com.SPM.backend.IT20122096.TripPlaning.Service;

import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface TripPlanService {

    ResponseEntity<?> saveTripPlan(TripPlanDTO tripPlan);

    ResponseEntity<?> getAllTripPlans(ObjectId userId);
    ResponseEntity<?> getAllBookings(ObjectId userId);
    ResponseEntity<?> getAllPayments(ObjectId userId);
    ResponseEntity<?> getTripPlanById(ObjectId tripId);
    ResponseEntity<?> deleteTripPlanById(ObjectId tripId);
    ResponseEntity<?> payForTripPlan(PaymentDTO paymentDTO);
}
