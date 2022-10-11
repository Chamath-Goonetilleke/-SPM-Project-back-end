package com.SPM.backend.IT20122096.Places.Controller;

import com.SPM.backend.IT20122096.Common.BaseController;
import com.SPM.backend.IT20122096.Places.DTO.PlaceDTO;
import com.SPM.backend.IT20122096.Places.Service.PlaceService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceController extends BaseController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/place/save")
    public ResponseEntity<?> savePlace(@RequestBody PlaceDTO placeDTO){
        return placeService.savePlace(placeDTO);
    }
    @GetMapping("/place/getAll")
    public ResponseEntity<?> getAllPlaces(){
        return  placeService.getAllPlaces();
    }
    @GetMapping("/place/{id}")
    public ResponseEntity<?> getPlaceById(@PathVariable ObjectId id){
        return  placeService.getPlaceById(id);
    }
}
