package com.SPM.backend.IT20122096.TripPlaning.Service;

import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Entity.*;
import com.SPM.backend.IT20122096.TripPlaning.Repository.TripPlanRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripPlanServiceImpl implements TripPlanService {

    private final TripPlanRepository tripPlanRepository;

    public TripPlanServiceImpl(TripPlanRepository tripPlanRepository) {
        this.tripPlanRepository = tripPlanRepository;
    }

    @Override
    public ResponseEntity saveTripPlan(TripPlan tripPlan) {
        //Place
//        Place place = new Place();
//        List<VisitingPlace> visitingPlaces = new ArrayList<>();
//        for (VisitingPlace vPlace: tripPlanDTO.getPlace().getVisitingPlaces()
//             ) {
//            VisitingPlace visitingPlace = new VisitingPlace(vPlace.getId(), vPlace.getName(), vPlace.getImage());
//            visitingPlaces.add(visitingPlace);
//        }
//        place.setId(tripPlanDTO.getPlace().getId());
//        place.setVisitingPlaces(visitingPlaces);
//
//        //Hotel
//        Accommodation accommodation = new Accommodation();
//        List<Room> rooms = new ArrayList<>();
//        for (Room r:tripPlanDTO.getAccommodation().getRooms()
//             ) {
//            Room room= new Room(r.getRoomNumber(),r.getCategory(),r.getCapacity(),r.getPrice());
//            rooms.add(room);
//        }
//        accommodation.s

//        TripPlan tripPlan = new TripPlan();


        return new ResponseEntity(tripPlanRepository.save(tripPlan), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllTripPlans(ObjectId userId) {
        List<TripPlan> tripPlans = tripPlanRepository.getTripPlanByUserId(userId);
        return new ResponseEntity(tripPlans, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getTripPlanById(ObjectId tripId) {
        TripPlan tripPlan = tripPlanRepository.findById(tripId).get();
        return new ResponseEntity(tripPlan, HttpStatus.OK);

    }

    @Override
    public ResponseEntity updateTripPlanById(ObjectId tripId) {
        return null;
    }

    @Override
    public ResponseEntity deleteTripPlanById(ObjectId tripId) {
        tripPlanRepository.deleteById(tripId);
        return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
    }
}