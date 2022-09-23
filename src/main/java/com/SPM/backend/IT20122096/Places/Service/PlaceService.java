package com.SPM.backend.IT20122096.Places.Service;

import com.SPM.backend.IT20122096.Places.DTO.PlaceDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface PlaceService {

    ResponseEntity savePlace(PlaceDTO placeDTO);
    ResponseEntity getAllPlaces();
    ResponseEntity getPlaceById(ObjectId id);
}
