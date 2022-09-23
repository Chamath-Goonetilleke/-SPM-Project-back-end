package com.SPM.backend.IT20122096.Places.Service;

import com.SPM.backend.IT20122096.Places.DTO.PlaceDTO;
import com.SPM.backend.IT20122096.Places.Entity.Place;
import com.SPM.backend.IT20122096.Places.Entity.VisitingPlace;
import com.SPM.backend.IT20122096.Places.Repository.PlaceRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceServiceImpl implements PlaceService{

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity savePlace(PlaceDTO placeDTO) {
        Place place = new Place();

        place.setName(placeDTO.getName());
        place.setDistrict(placeDTO.getDistrict());
        place.setProvince(placeDTO.getProvince());
        place.setDescription(placeDTO.getDescription());
        place.setImageURL(placeDTO.getImageURL());

        List<VisitingPlace> visitingPlaces = new ArrayList<>();
        Long count = 0L;
        for (VisitingPlace vPlace: placeDTO.getVisitingPlaces()) {

            VisitingPlace visitingPlace = new VisitingPlace();
            visitingPlace.setName(vPlace.getName());
            visitingPlace.setImage(vPlace.getImage());
            visitingPlace.setId(System.currentTimeMillis()+count);
            count++;

            visitingPlaces.add(visitingPlace);
        }
        place.setVisitingPlaces(visitingPlaces);
        return new ResponseEntity(placeRepository.save(place), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllPlaces() {
        return new ResponseEntity(placeRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getPlaceById(ObjectId id) {
        Place place = placeRepository.findById(id).get();
        return new ResponseEntity(place, HttpStatus.OK);
    }
}
