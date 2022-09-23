package com.SPM.backend.IT20192082.repository;

import com.SPM.backend.IT20192082.model.PlaceManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlaceManagementRepository extends MongoRepository<PlaceManagement, String> {
    List<PlaceManagement> findByNameContaining(String name);
    List<PlaceManagement> findByApproved(boolean approved);
    List<PlaceManagement> findByFavorite(boolean favorite);

}

