package com.SPM.backend.IT20122096.TripPlaning.Repository;

import com.SPM.backend.IT20122096.TripPlaning.Entity.Payment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, ObjectId> {
}
