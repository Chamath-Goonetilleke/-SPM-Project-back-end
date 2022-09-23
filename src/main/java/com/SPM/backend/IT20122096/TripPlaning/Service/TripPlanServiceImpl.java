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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity saveTripPlan(TripPlan tripPlan) {
        //Place
//        Place place = new Place();
//        List<VisitingPlace> visitingPlaces = new ArrayList<>();
//        for (VisitingPlace vPlace: tripPlanDTO.getPlace().getVisitingPlaces()
//             ) {
//            VisitingPlace visitingPlace = new VisitingPlace(vPlace.getId(), vPlace.getName(), vPlace.getImage());
//            visitingPlaces.add(visitingPlace);
//        }
//        place.setId(tripPlanDTO.getPlace().getId());
//        place.setVisitingPlaces(visitingPlaces);
//
//        //Hotel
//        Accommodation accommodation = new Accommodation();
//        List<Room> rooms = new ArrayList<>();
//        for (Room r:tripPlanDTO.getAccommodation().getRooms()
//             ) {
//            Room room= new Room(r.getRoomNumber(),r.getCategory(),r.getCapacity(),r.getPrice());
//            rooms.add(room);
//        }
//        accommodation.s

//        TripPlan tripPlan = new TripPlan();


        return new ResponseEntity(tripPlanRepository.save(tripPlan), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllTripPlans(ObjectId userId) {
        List<TripPlan> tripPlans = tripPlanRepository.getTripPlanByUserId(userId);

        List<TripPlan> fullTripPlan = new ArrayList<>();
        for (TripPlan plan : tripPlans
        ) {
            TripPlan tripPlan = plan;
            Hotel hotel = hotelRepository.findById(tripPlan.getAccommodation().getId()).get();
            tripPlan.getAccommodation().setImage(hotel.getImageURL());
            tripPlan.getAccommodation().setName(hotel.getName());

            Transport transport = transportRepository.findById(tripPlan.getTransportation().getId()).get();
            tripPlan.getTransportation().setImage(transport.getImageURL());
            tripPlan.getTransportation().setName(transport.getName());

            Place place =placeRepository.findById(tripPlan.getPlace().getId()).get();
            tripPlan.getPlace().setName(place.getName());
            tripPlan.getPlace().setImage(place.getImageURL());

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
            Hotel hotel = hotelRepository.findById(tripPlan.getAccommodation().getId()).get();
            tripPlan.getAccommodation().setImage(hotel.getImageURL());
            tripPlan.getAccommodation().setName(hotel.getName());

            Transport transport = transportRepository.findById(tripPlan.getTransportation().getId()).get();
            tripPlan.getTransportation().setImage(transport.getImageURL());
            tripPlan.getTransportation().setName(transport.getName());

            Place place =placeRepository.findById(tripPlan.getPlace().getId()).get();
            tripPlan.getPlace().setName(place.getName());
            tripPlan.getPlace().setImage(place.getImageURL());

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
                TripPlan tripPlan = tripPlanRepository.findById(payment.getTripPlanId()).get();
                paymentResponseDTO.setName(tripPlan.getName());
            }
            else {
                TravelPackage travelPackage = travelPackageRepository.findById(payment.getTripPlanId()).get();
                paymentResponseDTO.setName(travelPackage.getName());
            }
            paymentDTOS.add(paymentResponseDTO);
        }
        return new ResponseEntity(paymentDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getTripPlanById(ObjectId tripId) {
        TripPlan tripPlan = tripPlanRepository.findById(tripId).get();

        Hotel hotel = hotelRepository.findById(tripPlan.getAccommodation().getId()).get();
        tripPlan.getAccommodation().setImage(hotel.getImageURL());
        tripPlan.getAccommodation().setName(hotel.getName());

        Transport transport = transportRepository.findById(tripPlan.getTransportation().getId()).get();
        tripPlan.getTransportation().setImage(transport.getImageURL());
        tripPlan.getTransportation().setName(transport.getName());

        Place place =placeRepository.findById(tripPlan.getPlace().getId()).get();
        tripPlan.getPlace().setName(place.getName());
        tripPlan.getPlace().setImage(place.getImageURL());

        return new ResponseEntity(tripPlan, HttpStatus.OK);

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
            TripPlan tripPlan = tripPlanRepository.findById(paymentDTO.getTripPlanId()).get();
            tripPlan.setBooked(true);
            tripPlanRepository.save(tripPlan);
        }

        return new ResponseEntity("Payment Success", HttpStatus.OK);
    }
}
