package com.SPM.backend.controller;

import com.SPM.backend.model.PlaceManagement;
import com.SPM.backend.repository.PlaceManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PlaceManagementController {
    @Autowired
    PlaceManagementRepository placeManagementRepository;

    @GetMapping("/places")
    public ResponseEntity<List<PlaceManagement>> getAllPlaces(@RequestParam(required = false) String name) {
        try {
            List<PlaceManagement> placeManagements = new ArrayList<PlaceManagement>();
            if(name == null)
                placeManagementRepository.findAll().forEach(placeManagements::add);
            else
                placeManagementRepository.findByNameContaining(name).forEach(placeManagements::add);
            if(placeManagements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(placeManagements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<PlaceManagement> getPlaceById(@PathVariable("id") String id) {
        Optional<PlaceManagement> placeData = placeManagementRepository.findById(id);
        return placeData.map(placeManagement -> new ResponseEntity<>(placeManagement, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/place/approved")
    public ResponseEntity<List<PlaceManagement>> findByApproved() {
        try {
            List<PlaceManagement> placeManagements = placeManagementRepository.findByApproved(true);
            if(placeManagements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(placeManagements, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/approved")
    public ResponseEntity<List<PlaceManagement>> findByUserApproved() {
        try {
            List<PlaceManagement> placeManagements = placeManagementRepository.findByApproved(false);
            if(placeManagements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(placeManagements, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/favorite")
    public ResponseEntity<List<PlaceManagement>> findByUserFavorite() {
        try {
            List<PlaceManagement> placeManagements = placeManagementRepository.findByFavorite(true);
            if(placeManagements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(placeManagements, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PostMapping("/place")
    public ResponseEntity<PlaceManagement> createPlace(@RequestBody PlaceManagement placeManagement) {
        try {
            PlaceManagement _placeManagement = placeManagementRepository.save(new PlaceManagement(placeManagement.getName(), placeManagement.getImage(), placeManagement.getLocation(), placeManagement.getRating(), placeManagement.getDescription(),placeManagement.getRatingCount(), placeManagement.isApproved(), placeManagement.isFavorite(), placeManagement.getOtherPlacesArray()));
            return new ResponseEntity<>(_placeManagement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<PlaceManagement> updatePlace(@PathVariable("id") String id, @RequestBody PlaceManagement placeManagement) {
        Optional<PlaceManagement> placeData = placeManagementRepository.findById(id);
        if (placeData.isPresent()) {
            PlaceManagement _placeManagement = placeData.get();
            _placeManagement.setName(placeManagement.getName());
            _placeManagement.setImage(placeManagement.getImage());
            _placeManagement.setLocation(placeManagement.getLocation());
            _placeManagement.setRating(placeManagement.getRating());
            _placeManagement.setDescription(placeManagement.getDescription());
            _placeManagement.setOtherPlacesArray(placeManagement.getOtherPlacesArray());
            _placeManagement.setApproved(placeManagement.isApproved());
            return new ResponseEntity<>(placeManagementRepository.save(_placeManagement), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/user/place/{id}")
    public ResponseEntity<String> patchPlace(@PathVariable("id") String id, @RequestBody PlaceManagement placeManagement) {
        Optional<PlaceManagement> placeData = placeManagementRepository.findById(id);
        if (placeData.isPresent()) {
            PlaceManagement _placeManagement = placeData.get();
            _placeManagement.setRating(placeManagement.getRating());
            _placeManagement.setRatingCount(placeManagement.getRatingCount());
            this.placeManagementRepository.save(_placeManagement);
            return ResponseEntity.ok("Resource with ID " + id + "was successfully updated.");
        }  else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/user/favorite/{id}")
    public ResponseEntity<String> patchFavorite(@PathVariable("id") String id, @RequestBody PlaceManagement placeManagement) {
        Optional<PlaceManagement> placeData = placeManagementRepository.findById(id);
        if (placeData.isPresent()) {
            PlaceManagement _placeManagement = placeData.get();
            _placeManagement.setFavorite(placeManagement.isFavorite());
            this.placeManagementRepository.save(_placeManagement);
            return ResponseEntity.ok("Resource with ID " + id + "was successfully updated.");
        }  else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<HttpStatus> deletePlace(@PathVariable("id") String id) {
        try {
            placeManagementRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
