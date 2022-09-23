package com.SPM.backend.IT20122096.Transport.Repository;

import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends MongoRepository<Transport, ObjectId> {
}
