package com.SPM.backend.IT20122096.TravelPackage.Service;

import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import com.SPM.backend.IT20122096.TravelPackage.Repository.TravelPackageRepository;
import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.repository.HotelRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TravelPackageServiceImpl implements TravelPackageService{

    private final TravelPackageRepository travelPackageRepository;
    private final HotelRepository hotelRepository;
    private final TransportRepository transportRepository;

    public TravelPackageServiceImpl(TravelPackageRepository travelPackageRepository, HotelRepository hotelRepository, TransportRepository transportRepository) {
        this.travelPackageRepository = travelPackageRepository;
        this.hotelRepository = hotelRepository;
        this.transportRepository = transportRepository;
    }

    @Override
    public ResponseEntity saveNewPackage(TravelPackageDTO travelPackageDTO) {

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setName(travelPackageDTO.getName());
        travelPackage.setType(travelPackageDTO.getType());
        travelPackage.setNoOfDays(travelPackageDTO.getNoOfDays());
        travelPackage.setPlace(travelPackageDTO.getPlace());
        travelPackage.setAccommodation(travelPackageDTO.getAccommodation());
        travelPackage.setTransportation(travelPackageDTO.getTransportation());
        travelPackage.setTotalCost(travelPackageDTO.getTotalCost());
        travelPackage.setDiscount(travelPackageDTO.getDiscount());

        return new ResponseEntity(travelPackageRepository.save(travelPackage), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updatePackage(TravelPackageDTO travelPackageDTO) {

        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageDTO.getId()).get();
        travelPackage.setName(travelPackageDTO.getName());
        travelPackage.setType(travelPackageDTO.getType());
        travelPackage.setNoOfDays(travelPackageDTO.getNoOfDays());

        return new ResponseEntity(travelPackageRepository.save(travelPackage), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllPackages() {
        List<TravelPackage> travelPackages = travelPackageRepository.findAll();
        List<TravelPackage> fullTravelPackage = new ArrayList<>();
        for (TravelPackage travelPackage:travelPackages
        ) {
            TravelPackage Tpackage = travelPackage;
            Hotel hotel = hotelRepository.findById(Tpackage.getAccommodation().getId()).get();
            Tpackage.getAccommodation().setImage(hotel.getImageURL());
            Tpackage.getAccommodation().setName(hotel.getName());

            Transport transport = transportRepository.findById(Tpackage.getTransportation().getId()).get();
            Tpackage.getTransportation().setImage(transport.getImageURL());
            Tpackage.getTransportation().setName(transport.getName());

            fullTravelPackage.add(Tpackage);
        }
        return new ResponseEntity(fullTravelPackage,HttpStatus.OK);
    }

    @Override
    public ResponseEntity getPackageById(ObjectId id) {
        TravelPackage travelPackage = travelPackageRepository.findById(id).get();

        Hotel hotel = hotelRepository.findById(travelPackage.getAccommodation().getId()).get();
        travelPackage.getAccommodation().setImage(hotel.getImageURL());
        travelPackage.getAccommodation().setName(hotel.getName());

        Transport transport = transportRepository.findById(travelPackage.getTransportation().getId()).get();
        travelPackage.getTransportation().setImage(transport.getImageURL());
        travelPackage.getTransportation().setName(transport.getName());
        return new ResponseEntity(travelPackage,HttpStatus.OK);
    }

    @Override
    public ResponseEntity deletePackageById(ObjectId id) {
        travelPackageRepository.deleteById(id);
        return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
    }
}
