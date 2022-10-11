package com.SPM.backend.IT20122096.TravelPackage.Service;

import com.SPM.backend.IT20122096.Places.Entity.Place;
import com.SPM.backend.IT20122096.Places.Repository.PlaceRepository;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import com.SPM.backend.IT20122096.TravelPackage.Repository.TravelPackageRepository;
import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.repository.HotelRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TravelPackageServiceImpl implements TravelPackageService{

    private final TravelPackageRepository travelPackageRepository;
    private final HotelRepository hotelRepository;
    private final TransportRepository transportRepository;
    private final PlaceRepository placeRepository;

    public TravelPackageServiceImpl(TravelPackageRepository travelPackageRepository, HotelRepository hotelRepository, TransportRepository transportRepository, PlaceRepository placeRepository) {
        this.travelPackageRepository = travelPackageRepository;
        this.hotelRepository = hotelRepository;
        this.transportRepository = transportRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<?> saveNewPackage(TravelPackageDTO travelPackageDTO) {

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setName(travelPackageDTO.getName());
        travelPackage.setType(travelPackageDTO.getType());
        travelPackage.setNoOfDays(travelPackageDTO.getNoOfDays());
        travelPackage.setPlace(travelPackageDTO.getPlace());
        travelPackage.setAccommodation(travelPackageDTO.getAccommodation());
        travelPackage.setTransportation(travelPackageDTO.getTransportation());
        travelPackage.setTotalCost(travelPackageDTO.getTotalCost());
        travelPackage.setDiscount(travelPackageDTO.getDiscount());

        return new ResponseEntity<>(travelPackageRepository.save(travelPackage), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updatePackage(TravelPackageDTO travelPackageDTO) {

        Optional<TravelPackage> travelPackage1 = travelPackageRepository.findById(travelPackageDTO.getId());
        if(travelPackage1.isPresent()){
            TravelPackage travelPackage = travelPackage1.get();
            travelPackage.setName(travelPackageDTO.getName());
            travelPackage.setType(travelPackageDTO.getType());
            travelPackage.setNoOfDays(travelPackageDTO.getNoOfDays());
            return new ResponseEntity<>(travelPackageRepository.save(travelPackage), HttpStatus.OK);

        }
        return new ResponseEntity<>("Package dose not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getAllPackages() {
        List<TravelPackage> travelPackages = travelPackageRepository.findAll();
        List<TravelPackage> fullTravelPackage = new ArrayList<>();
        for (TravelPackage travelPackage:travelPackages
        ) {
            TravelPackage Tpackage = travelPackage;
            Optional<Hotel> hotel = hotelRepository.findById(travelPackage.getAccommodation().getId());
            if (hotel.isPresent()){
                Tpackage.getAccommodation().setImage(hotel.get().getImageURL());
                Tpackage.getAccommodation().setName(hotel.get().getName());
            }

            Optional<Transport> transport = transportRepository.findById(travelPackage.getTransportation().getId());
            if (transport.isPresent()){
                Tpackage.getTransportation().setImage(transport.get().getImageURL());
                Tpackage.getTransportation().setName(transport.get().getName());
            }

            Optional<Place> place =placeRepository.findById(travelPackage.getPlace().getId());
            if (place.isPresent()){
                Tpackage.getPlace().setName(place.get().getName());
                Tpackage.getPlace().setImage(place.get().getImageURL());
            }

            fullTravelPackage.add(Tpackage);
        }
        return new ResponseEntity<>(fullTravelPackage,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getPackageById(ObjectId id) {
        Optional<TravelPackage> travelPackage1 = travelPackageRepository.findById(id);
        if (travelPackage1.isPresent()){
            TravelPackage travelPackage = travelPackage1.get();
            Optional<Hotel> hotel = hotelRepository.findById(travelPackage.getAccommodation().getId());
            if (hotel.isPresent()){
                travelPackage.getAccommodation().setImage(hotel.get().getImageURL());
                travelPackage.getAccommodation().setName(hotel.get().getName());
            }

            Optional<Transport> transport = transportRepository.findById(travelPackage.getTransportation().getId());
            if (transport.isPresent()){
                travelPackage.getTransportation().setImage(transport.get().getImageURL());
                travelPackage.getTransportation().setName(transport.get().getName());
            }

            Optional<Place> place =placeRepository.findById(travelPackage.getPlace().getId());
            if (place.isPresent()){
                travelPackage.getPlace().setName(place.get().getName());
                travelPackage.getPlace().setImage(place.get().getImageURL());
            }

            return new ResponseEntity<>(travelPackage,HttpStatus.OK);
        }
        return new ResponseEntity<>("Package dose not exist", HttpStatus.BAD_REQUEST);


    }

    @Override
    public ResponseEntity<?> deletePackageById(ObjectId id) {
        travelPackageRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
