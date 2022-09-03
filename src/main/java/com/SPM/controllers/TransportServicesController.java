package com.SPM.controllers;

import com.SPM.domains.TransportServices;
import com.SPM.services.ServiceTransportServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, allowedHeaders = "*")
@RequestMapping(path = "/transport-services")
@Slf4j
public class TransportServicesController {

    private final ServiceTransportServices serviceTransportServices;

    @Autowired
    public TransportServicesController(ServiceTransportServices serviceTransportServices) {
        this.serviceTransportServices = serviceTransportServices;
    }

    @GetMapping("/search")
    public ResponseEntity<List<TransportServices>> searchTransportServices(@RequestParam String searchString) {
        try {
            return new ResponseEntity<>(serviceTransportServices.searchTransportServices(searchString), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error occurred while searching transport services: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/requested")
    public ResponseEntity<List<TransportServices>> getRequestedTransportServices() {
        try {
            return new ResponseEntity<>(serviceTransportServices.getRequestedTransportServicesInformation(), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error occurred while fetching all requested the transport services: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/approve")
    public ResponseEntity<TransportServices> approveTransportService(@RequestParam String id) {
        try {
            return new ResponseEntity<>(serviceTransportServices.approveTransportService(id), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while fetching approved transport service: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/decline")
    public ResponseEntity<TransportServices> declineTransportService(@RequestParam String id) {
        try {
            serviceTransportServices.declineTransportService(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while fetching declined transport service: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/registered")
    public ResponseEntity<List<TransportServices>> getTransportService() {
        try {
            return new ResponseEntity<>(serviceTransportServices.getRegisteredTransportServicesInformation(), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error occurred while fetching all registered transport services: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TransportServices> addTransportService(@RequestBody TransportServices businessInformation) {
        try {
            return new ResponseEntity<>(serviceTransportServices.addTransportService(businessInformation), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
