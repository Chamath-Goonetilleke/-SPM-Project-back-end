package com.SPM.backend.IT20122096.TripPlaning.Service;


import com.SPM.backend.IT20122096.CommonData;
import com.SPM.backend.IT20122096.Places.Repository.PlaceRepository;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
import com.SPM.backend.IT20122096.TravelPackage.Repository.TravelPackageRepository;
import com.SPM.backend.IT20122096.TravelPackage.Service.TravelPackageService;
import com.SPM.backend.IT20122096.TripPlaning.DTO.BookingsDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentResponseDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Entity.*;
import com.SPM.backend.IT20122096.TripPlaning.Repository.PaymentRepository;
import com.SPM.backend.IT20122096.TripPlaning.Repository.TripPlanRepository;
import com.SPM.backend.IT20122614.model.Hotel;
import com.SPM.backend.IT20122614.repository.HotelRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TripPlanServiceImplTest {

    @Autowired
    TripPlanServiceImpl tripPlanService;
    @MockBean
    TripPlanRepository tripPlanRepository;
    @MockBean
    HotelRepository hotelRepository;
    @MockBean
    PaymentRepository paymentRepository;
    @MockBean
    TransportRepository transportRepository;
    @MockBean
    TravelPackageService travelPackageService;
    @MockBean
    TravelPackageRepository travelPackageRepository;
    @MockBean
    PlaceRepository placeRepository;

    CommonData commonData = new CommonData();

    @Test
    void TestSaveTripPlan() {
        TripPlanDTO tripPlanDTO = commonData.getTripDTO();
        TripPlan tripPlan = commonData.getTripPlan();

        Mockito.when(tripPlanRepository.save(Mockito.any())).thenReturn(tripPlan);
        ResponseEntity<?> result = tripPlanService.saveTripPlan(tripPlanDTO);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());

    }

    @Test
    void TestGetAllTripPlans() {

        Hotel hotel = new Hotel();
        hotel.setName("TestHotel");
        hotel.setImageURL("HotelImageUrl");

        Transport transport = new Transport();
        transport.setName("TestTransport");
        transport.setImageURL("TransportImageUrl");

        com.SPM.backend.IT20122096.Places.Entity.Place place = new com.SPM.backend.IT20122096.Places.Entity.Place();
        place.setName("TestPlace");
        place.setImageURL("PlaceImageUrl");

        Mockito.when(tripPlanRepository.getTripPlanByUserId(new ObjectId("6331d725d613b66fd9db0f19"))).thenReturn(commonData.getTripPlanList("plans"));
        Mockito.when(hotelRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(hotel));
        Mockito.when(transportRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(transport));
        Mockito.when(placeRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(place));

        ResponseEntity<?> result = tripPlanService.getAllTripPlans(new ObjectId("6331d725d613b66fd9db0f19"));
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
        Assertions.assertEquals(4, ((List<?>) result.getBody()).size());

    }

    @Test
    void TestGetAllBookings() {
        Hotel hotel = new Hotel();
        hotel.setName("TestHotel");
        hotel.setImageURL("HotelImageUrl");

        Transport transport = new Transport();
        transport.setName("TestTransport");
        transport.setImageURL("TransportImageUrl");

        com.SPM.backend.IT20122096.Places.Entity.Place place = new com.SPM.backend.IT20122096.Places.Entity.Place();
        place.setName("TestPlace");
        place.setImageURL("PlaceImageUrl");

        Mockito.when(tripPlanRepository.getBookedTripPlanByUserId(new ObjectId("6331d725d613b66fd9db0f19"))).thenReturn(commonData.getTripPlanList("bookings"));
        Mockito.when(hotelRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(hotel));
        Mockito.when(transportRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(transport));
        Mockito.when(placeRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(place));
        Mockito.when(paymentRepository.getPaymentByUserId(new ObjectId("6331d725d613b66fd9db0f19"))).thenReturn(commonData.getPaymentList());
        Mockito.when(travelPackageService.getAllPackages()).thenReturn(new ResponseEntity(commonData.getPackageList(), HttpStatus.OK));

        ResponseEntity<?> result = tripPlanService.getAllBookings(new ObjectId("6331d725d613b66fd9db0f19"));
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
        Assertions.assertEquals(2, ((BookingsDTO) result.getBody()).getTravelPackages().size());

    }

    @Test
    void TestGetAllPayments() {
        Mockito.when(paymentRepository.getPaymentByUserId(new ObjectId("6331d725d613b66fd9db0f19"))).thenReturn(commonData.getPaymentList());
        Mockito.when(tripPlanRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.ofNullable(commonData.getTripPlan()));
        Mockito.when(travelPackageRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.ofNullable(commonData.getPackage(2)));

        ResponseEntity<?> result = tripPlanService.getAllPayments(new ObjectId("6331d725d613b66fd9db0f19"));
        List<PaymentResponseDTO> paymentDTOS = (List<PaymentResponseDTO>) result.getBody();
        int tripPlans = 0;
        int packages = 0;
        assert paymentDTOS != null;
        for (PaymentResponseDTO paymentResponseDTO : paymentDTOS) {
            if (paymentResponseDTO.getType().equals("Trip Plan")) {
                tripPlans++;
            }
            if (paymentResponseDTO.getType().equals("Package")) {
                packages++;
            }
        }
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
        Assertions.assertEquals(4, ((List<?>) result.getBody()).size());
        Assertions.assertEquals(2, tripPlans);
        Assertions.assertEquals(2, packages);
    }

    @Test
    void TestGetTripPlanByIdSuccess() {
        Hotel hotel = new Hotel();
        hotel.setName("TestHotel");
        hotel.setImageURL("HotelImageUrl");

        Transport transport = new Transport();
        transport.setName("TestTransport");
        transport.setImageURL("TransportImageUrl");

        com.SPM.backend.IT20122096.Places.Entity.Place place = new com.SPM.backend.IT20122096.Places.Entity.Place();
        place.setName("TestPlace");
        place.setImageURL("PlaceImageUrl");

        Mockito.when(tripPlanRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(commonData.getTripPlan()));
        Mockito.when(hotelRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(hotel));
        Mockito.when(transportRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(transport));
        Mockito.when(placeRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(place));

        ResponseEntity<?> result = tripPlanService.getTripPlanById(new ObjectId("633372dc0a880e615b3efbce"));

        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
        Assertions.assertEquals(TripPlan.class.getName(), result.getBody().getClass().getName());

    }

    @Test
    void TestGetTripPlanByIdFailure() {

        Mockito.when(tripPlanRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.empty());

        ResponseEntity<?> result = tripPlanService.getTripPlanById(new ObjectId("633372dc0a880e615b3efbce"));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Plan dose not exist", result.getBody());

    }

    @Test
    void TestDeleteTripPlanById() {
        ResponseEntity<?> result = tripPlanService.deleteTripPlanById(new ObjectId("633372dc0a880e615b3efbce"));

        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Deleted Successfully", result.getBody());
    }
    @Test
    void TestPayForTripPlan(){
        Mockito.when(paymentRepository.save(Mockito.any())).thenReturn(commonData.getPayment());
        Mockito.when(tripPlanRepository.findById(Mockito.any())).thenReturn(Optional.of(commonData.getTripPlan()));
        Mockito.when(tripPlanRepository.save(Mockito.any())).thenReturn(commonData.getTripPlan());

        ResponseEntity<?> result = tripPlanService.payForTripPlan(commonData.getPaymentDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Payment Success", result.getBody());
    }


}
