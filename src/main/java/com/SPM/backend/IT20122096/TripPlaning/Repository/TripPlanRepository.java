package com.SPM.backend.IT20122096.TripPlaning.Repository;

import com.SPM.backend.IT20122096.TripPlaning.Entity.TripPlan;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripPlanRepository extends MongoRepository<TripPlan, ObjectId> {

    @Query("{'userId':?0}")
    List<TripPlan> getTripPlanByUserId(ObjectId userId);
    @Query("{'userId':?0,'isBooked': true}")
    List<TripPlan> getBookedTripPlanByUserId(ObjectId userId);
}
