package com.SPM.backend.IT20122096.TravelPackage.Repository;

import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends MongoRepository<TravelPackage, ObjectId> {
}
