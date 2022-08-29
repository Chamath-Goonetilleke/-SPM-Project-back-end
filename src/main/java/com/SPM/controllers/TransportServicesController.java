package com.SPM.controllers;

import com.SPM.domains.TransportTypes;
import com.SPM.services.TransportServices;
import com.SPM.domains.TransportBusinessInformation;
import com.SPM.types.RecordStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport-services")
@Slf4j
public class TransportServicesController {

    private final TransportServices transportServices;

    @Autowired
    public TransportServicesController(TransportServices transportServices) {
        this.transportServices = transportServices;
    }

    @GetMapping("/")
    public ResponseEntity<List<TransportBusinessInformation>> getAllTransportServices() {
        try {
            return new ResponseEntity<>(transportServices.getAllTransportBusinessInformation(), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error occurred while fetching all the transport services: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<TransportBusinessInformation>> searchTransportServices(@RequestParam String searchString) {
        try {
            return new ResponseEntity<>(transportServices.searchTransportServices(searchString), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error occurred while searching transport services: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/transport-service")
    public ResponseEntity<TransportBusinessInformation> getTransportService(@RequestParam String id) {
        try {
            return new ResponseEntity<>(transportServices.getTransportBusinessInformation(id), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error occurred while fetching all the transport services: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/add-business-information")
    public ResponseEntity<TransportBusinessInformation> addBusinessInformation(
            @RequestBody TransportBusinessInformation businessInformation) {
        try {
            return new ResponseEntity<>(transportServices.addBusinessInformation(businessInformation),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while saving business information: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-transport-services")
    public ResponseEntity<List<TransportTypes>> addTransportInformation(
            @RequestBody TransportTypes[] transportTypes) {
        try {
            return new ResponseEntity<>(transportServices.addTransportTypes(transportTypes),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while saving transport information: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-status")
    public ResponseEntity<TransportBusinessInformation> changeRecordStatus(@RequestParam String id,
                                                                           @RequestParam RecordStatus status) {
        try {
            return new ResponseEntity<>(transportServices.updateRecordStatus(id, status), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while updating record status: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
