package com.SPM.backend.IT20122096.Transport.Service;

import com.SPM.backend.IT20122096.Transport.DTO.TransportDTO;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Entity.Vehicle;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TransportServiceImpl implements TransportService{

    private TransportRepository transportRepository;

    public TransportServiceImpl(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public ResponseEntity saveTransportService(TransportDTO transportDTO) {

        Transport transport = new Transport();

        transport.setName(transportDTO.getName());
        transport.setDescription(transportDTO.getDescription());
        transport.setDistrict(transportDTO.getDistrict());
        transport.setImageURL(transportDTO.getImageURL());

        List<Vehicle> vehicles= new ArrayList<>();
        for (Vehicle vehicle: transportDTO.getVehicles()
             ) {
            Vehicle vehicle1 = new Vehicle(vehicle.getType(),vehicle.getCapacity(),vehicle.getPrice());
            vehicles.add(vehicle1);
        }

        transport.setVehicles(vehicles);

        return new ResponseEntity(transportRepository.save(transport), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllTransportServices() {
        return new ResponseEntity(transportRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity getTransportService(ObjectId id) {
        Optional<Transport> transport = transportRepository.findById(id);
        if(transport.isPresent()){
            return new ResponseEntity(transport,HttpStatus.OK);
        }
        return new ResponseEntity("Transport dose not exist", HttpStatus.BAD_REQUEST);
    }
}
