package com.SPM.backend.repository;

import com.SPM.backend.model.PlaceManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlaceManagementRepository extends MongoRepository<PlaceManagement, String> {
    List<PlaceManagement> findByNameContaining(String name);
}
