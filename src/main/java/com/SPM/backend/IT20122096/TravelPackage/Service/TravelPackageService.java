package com.SPM.backend.IT20122096.TravelPackage.Service;

import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface TravelPackageService {

    ResponseEntity saveNewPackage(TravelPackageDTO travelPackageDTO);
    ResponseEntity updatePackage(TravelPackageDTO travelPackageDTO);
    ResponseEntity getAllPackages();
    ResponseEntity getPackageById(ObjectId id);
    ResponseEntity deletePackageById(ObjectId id);

}
