package com.SPM.backend.IT20122096.Places.Repository;

import com.SPM.backend.IT20122096.Places.Entity.Place;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends MongoRepository<Place, ObjectId> {
}
