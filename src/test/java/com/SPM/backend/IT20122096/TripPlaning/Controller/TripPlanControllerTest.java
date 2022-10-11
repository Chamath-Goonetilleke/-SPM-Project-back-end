package com.SPM.backend.IT20122096.TripPlaning.Controller;

import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Service.TripPlanService;
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TripPlanControllerTest {

    @Autowired
    TripPlanController tripPlanController;
    @MockBean
    TripPlanService tripPlanService;

    @Test
    void testGetTripPlanById() {
        ObjectId id = new ObjectId("633372dc0a880e615b3efbce");
        Mockito.when(tripPlanService.getTripPlanById(id))
                .thenReturn(new ResponseEntity("Trip Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.getTripPlanById(id);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Trip Object", result.getBody());

    }

    @Test
    void testGetAllTripPlans() {
        ObjectId id = new ObjectId("633372dc0a880e615b3efbce");
        Mockito.when(tripPlanService.getAllTripPlans(id))
                .thenReturn(new ResponseEntity("Test Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.getAllTripPlans(id);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Test Object", result.getBody());
    }

    @Test
    void testGetAllBookings() {
        ObjectId id = new ObjectId("633372dc0a880e615b3efbce");
        Mockito.when(tripPlanService.getAllBookings(id))
                .thenReturn(new ResponseEntity("Test Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.getAllBookings(id);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Test Object", result.getBody());
    }

    @Test
    void testGetAllPayments() {
        ObjectId id = new ObjectId("633372dc0a880e615b3efbce");
        Mockito.when(tripPlanService.getAllPayments(id))
                .thenReturn(new ResponseEntity("Test Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.getAllPayments(id);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Test Object", result.getBody());
    }

    @Test
    void testSaveTripPlan() {
        TripPlanDTO tripPlanDTO = new TripPlanDTO();
        Mockito.when(tripPlanService.saveTripPlan(tripPlanDTO))
                .thenReturn(new ResponseEntity("Test Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.saveTripPlan(tripPlanDTO);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Test Object", result.getBody());
    }

    @Test
    void testDeleteTripPlanById() {
        ObjectId id = new ObjectId("633372dc0a880e615b3efbce");
        Mockito.when(tripPlanService.deleteTripPlanById(id))
                .thenReturn(new ResponseEntity("Test Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.deleteTripPlanById(id);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Test Object", result.getBody());
    }

    @Test
    void testPayForTripPlan() {
        PaymentDTO paymentDTO = new PaymentDTO();
        Mockito.when(tripPlanService.payForTripPlan(paymentDTO))
                .thenReturn(new ResponseEntity("Test Object", HttpStatus.OK));
        ResponseEntity<?> result = tripPlanController.payForTripPlan(paymentDTO);
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Test Object", result.getBody());
    }

}
