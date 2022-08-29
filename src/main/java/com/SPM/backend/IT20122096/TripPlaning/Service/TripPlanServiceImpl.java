package com.SPM.backend.IT20122096.TripPlaning.Service;

import com.SPM.backend.IT20122096.TripPlaning.Entity.TripPlan;
import com.SPM.backend.IT20122096.TripPlaning.Repository.TripPlanRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TripPlanServiceImpl implements TripPlanService{

    private final TripPlanRepository tripPlanRepository;

    public TripPlanServiceImpl(TripPlanRepository tripPlanRepository) {
        this.tripPlanRepository = tripPlanRepository;
    }

    @Override
    public ResponseEntity saveTripPlan(TripPlan tripPlan) {

        return new ResponseEntity(tripPlanRepository.save(tripPlan), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllTripPlans(ObjectId userId) {
        List<TripPlan> tripPlans = tripPlanRepository.getTripPlanByUserId(userId);
        return new ResponseEntity(tripPlans, HttpStatus.OK);
    }
}
