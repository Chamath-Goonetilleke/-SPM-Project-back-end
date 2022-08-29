package com.SPM.repository;

import com.SPM.domains.TransportTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportTypesRepository extends
        MongoRepository<TransportTypes, String> {
}
