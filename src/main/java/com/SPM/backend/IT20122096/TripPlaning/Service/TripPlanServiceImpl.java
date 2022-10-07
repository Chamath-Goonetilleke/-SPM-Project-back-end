package com.SPM.backend.IT20122096.TripPlaning.Service;

import com.SPM.backend.IT20122096.Places.Entity.Place;
import com.SPM.backend.IT20122096.Places.Repository.PlaceRepository;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import com.SPM.backend.IT20122096.TravelPackage.Repository.TravelPackageRepository;
import com.SPM.backend.IT20122096.TravelPackage.Service.TravelPackageService;
import com.SPM.backend.IT20122096.TripPlaning.DTO.BookingsDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentResponseDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Entity.*;
import com.SPM.backend.IT20122096.TripPlaning.Repository.PaymentRepository;
import com.SPM.backend.IT20122096.TripPlaning.Repository.TripPlanRepository;
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
public class TripPlanServiceImpl implements TripPlanService {

    private final TripPlanRepository tripPlanRepository;
    private final HotelRepository hotelRepository;
    private final PaymentRepository paymentRepository;
    private final TransportRepository transportRepository;
    private final TravelPackageService travelPackageService;
    private final TravelPackageRepository travelPackageRepository;
    private final PlaceRepository placeRepository;

    public TripPlanServiceImpl(TripPlanRepository tripPlanRepository, HotelRepository hotelRepository, PaymentRepository paymentRepository, TransportRepository transportRepository, TravelPackageService travelPackageService, TravelPackageRepository travelPackageRepository, PlaceRepository placeRepository) {
        this.tripPlanRepository = tripPlanRepository;
        this.hotelRepository = hotelRepository;
        this.paymentRepository = paymentRepository;
        this.transportRepository = transportRepository;
        this.travelPackageService = travelPackageService;
        this.travelPackageRepository = travelPackageRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity saveTripPlan(TripPlanDTO tripPlanDTO) {

        TripPlan tripPlan = new TripPlan();
        tripPlan.setUserId(tripPlanDTO.getUserId());
        tripPlan.setName(tripPlanDTO.getName());
        tripPlan.setType(tripPlanDTO.getType());
        tripPlan.setStartDate(tripPlanDTO.getStartDate());
        tripPlan.setEndDate(tripPlanDTO.getEndDate());
        tripPlan.setPlace(tripPlanDTO.getPlace());
        tripPlan.setAccommodation(tripPlanDTO.getAccommodation());
        tripPlan.setTransportation(tripPlanDTO.getTransportation());
        tripPlan.setTotalCost(tripPlanDTO.getTotalCost());
        tripPlan.setBooked(false);

    return new ResponseEntity(tripPlanRepository.save(tripPlan), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllTripPlans(ObjectId userId) {
        List<TripPlan> tripPlans = tripPlanRepository.getTripPlanByUserId(userId);

        List<TripPlan> fullTripPlan = new ArrayList<>();
        for (TripPlan plan : tripPlans
        ) {
            TripPlan tripPlan = plan;
            Optional<Hotel> hotel = hotelRepository.findById(plan.getAccommodation().getId());
            if (hotel.isPresent()){
                tripPlan.getAccommodation().setImage(hotel.get().getImageURL());
                tripPlan.getAccommodation().setName(hotel.get().getName());
            }

            Optional<Transport> transport = transportRepository.findById(plan.getTransportation().getId());
            if (transport.isPresent()){
                tripPlan.getTransportation().setImage(transport.get().getImageURL());
                tripPlan.getTransportation().setName(transport.get().getName());
            }

            Optional<Place> place =placeRepository.findById(plan.getPlace().getId());
            if (place.isPresent()){
                tripPlan.getPlace().setName(place.get().getName());
                tripPlan.getPlace().setImage(place.get().getImageURL());
            }

            fullTripPlan.add(tripPlan);
        }

        return new ResponseEntity(fullTripPlan, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllBookings(ObjectId userId) {
        List<TripPlan> tripPlans = tripPlanRepository.getBookedTripPlanByUserId(userId);

        List<TripPlan> fullTripPlan = new ArrayList<>();
        for (TripPlan plan : tripPlans
        ) {
            TripPlan tripPlan = plan;
            Optional<Hotel> hotel = hotelRepository.findById(plan.getAccommodation().getId());
            if (hotel.isPresent()){
                tripPlan.getAccommodation().setImage(hotel.get().getImageURL());
                tripPlan.getAccommodation().setName(hotel.get().getName());
            }

            Optional<Transport> transport = transportRepository.findById(plan.getTransportation().getId());
            if (transport.isPresent()){
                tripPlan.getTransportation().setImage(transport.get().getImageURL());
                tripPlan.getTransportation().setName(transport.get().getName());
            }

            Optional<Place> place =placeRepository.findById(plan.getPlace().getId());
            if (place.isPresent()){
                tripPlan.getPlace().setName(place.get().getName());
                tripPlan.getPlace().setImage(place.get().getImageURL());
            }

            fullTripPlan.add(tripPlan);
        }
        List<Payment> payments = paymentRepository.getPaymentByUserId(userId);
        List<TravelPackage> travelPackages = (List<TravelPackage>) travelPackageService.getAllPackages().getBody();
        List<TravelPackage> bookedPackages = new ArrayList<>();
        for (TravelPackage travelPackage:travelPackages
             ) {
            for (Payment payment:payments
                 ) {
                if((payment.getTripPlanId().equals(travelPackage.getId()))){
                    bookedPackages.add(travelPackage);
                }
            }
        }
        BookingsDTO bookingsDTO = new BookingsDTO(fullTripPlan,bookedPackages);


        return new ResponseEntity(bookingsDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllPayments(ObjectId userId) {
        List<Payment> payments = paymentRepository.getPaymentByUserId(userId);
        List<PaymentResponseDTO> paymentDTOS = new ArrayList<>();
        for (Payment payment: payments
             ) {
            PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
            paymentResponseDTO.setType(payment.getType());
            paymentResponseDTO.setAmount(payment.getAmount());
            paymentResponseDTO.setDate(payment.getDate());

            if(payment.getType().equals("Trip Plan")){
                Optional<TripPlan> tripPlan = tripPlanRepository.findById(payment.getTripPlanId());
                tripPlan.ifPresent(plan -> paymentResponseDTO.setName(plan.getName()));
            }
            else {
                Optional<TravelPackage> travelPackage = travelPackageRepository.findById(payment.getTripPlanId());
                travelPackage.ifPresent(aPackage -> paymentResponseDTO.setName(aPackage.getName()));
            }
            paymentDTOS.add(paymentResponseDTO);
        }
        return new ResponseEntity(paymentDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getTripPlanById(ObjectId tripId) {
        Optional<TripPlan> tripPlan1 = tripPlanRepository.findById(tripId);
        if (tripPlan1.isPresent()){
            TripPlan tripPlan = tripPlan1.get();
            Optional<Hotel> hotel = hotelRepository.findById(tripPlan.getAccommodation().getId());
            if (hotel.isPresent()){
                tripPlan.getAccommodation().setImage(hotel.get().getImageURL());
                tripPlan.getAccommodation().setName(hotel.get().getName());
            }

            Optional<Transport> transport = transportRepository.findById(tripPlan.getTransportation().getId());
            if (transport.isPresent()){
                tripPlan.getTransportation().setImage(transport.get().getImageURL());
                tripPlan.getTransportation().setName(transport.get().getName());
            }

            Optional<Place> place =placeRepository.findById(tripPlan.getPlace().getId());
            if (place.isPresent()){
                tripPlan.getPlace().setName(place.get().getName());
                tripPlan.getPlace().setImage(place.get().getImageURL());
            }

            return new ResponseEntity(tripPlan, HttpStatus.OK);
        }
        return new ResponseEntity("Plan dose not exist", HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity updateTripPlanById(ObjectId tripId) {
        return null;
    }

    @Override
    public ResponseEntity deleteTripPlanById(ObjectId tripId) {
        tripPlanRepository.deleteById(tripId);
        return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity payForTripPlan(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setTripPlanId(paymentDTO.getTripPlanId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setType(paymentDTO.getType());
        payment.setDate(paymentDTO.getDate());
        payment.setUserId(paymentDTO.getUserId());

        paymentRepository.save(payment);

        if (paymentDTO.getType().equals("Trip Plan")) {
            Optional<TripPlan> tripPlan = tripPlanRepository.findById(paymentDTO.getTripPlanId());
            if (tripPlan.isPresent()){
                tripPlan.get().setBooked(true);
                tripPlanRepository.save(tripPlan.get());
            }
        }

        return new ResponseEntity("Payment Success", HttpStatus.OK);
    }
}
