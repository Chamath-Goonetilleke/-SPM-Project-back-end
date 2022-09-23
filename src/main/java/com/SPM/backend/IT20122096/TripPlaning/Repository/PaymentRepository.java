package com.SPM.backend.IT20122096.TripPlaning.Repository;

import com.SPM.backend.IT20122096.TripPlaning.Entity.Payment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, ObjectId> {

    @Query("{'userId':?0}")
    List<Payment> getPaymentByUserId(ObjectId userId);
}
