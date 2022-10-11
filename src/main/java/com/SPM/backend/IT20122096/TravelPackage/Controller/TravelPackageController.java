package com.SPM.backend.IT20122096.TravelPackage.Controller;

import com.SPM.backend.IT20122096.Common.BaseController;
import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import com.SPM.backend.IT20122096.TravelPackage.Service.TravelPackageService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TravelPackageController extends BaseController {

    private final TravelPackageService travelPackageService;

    public TravelPackageController(TravelPackageService travelPackageService) {
        this.travelPackageService = travelPackageService;
    }

    @PostMapping("/travelPackage/save")
    ResponseEntity<?> saveNewPackage(@RequestBody TravelPackageDTO travelPackageDTO) {
        return travelPackageService.saveNewPackage(travelPackageDTO);
    }

    @PostMapping("/travelPackage/update")
    ResponseEntity<?> updatePackage(@RequestBody TravelPackageDTO travelPackageDTO) {
        return travelPackageService.updatePackage(travelPackageDTO);
    }

    @GetMapping("/travelPackage/getAll")
    ResponseEntity<?> getAllPackages() {
        return travelPackageService.getAllPackages();
    }

    @GetMapping("/travelPackage/{id}")
    ResponseEntity<?> getPackageById(@PathVariable ObjectId id) {
        return travelPackageService.getPackageById(id);
    }

    @GetMapping("/travelPackage/delete/{id}")
    ResponseEntity<?> deletePackageById(@PathVariable ObjectId id) {
        return travelPackageService.deletePackageById(id);
    }

}
