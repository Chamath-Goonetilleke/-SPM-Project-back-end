package com.SPM.backend.IT20122614.repository;

import com.SPM.backend.IT20122614.model.Hotel;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, ObjectId> {

}
