package com.SPM.backend.IT20122096.TripPlaning.Entity_DTO;

import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentResponseDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TripPlanEntityDTOTest {

    @Test
    void TestAllEntities(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Accommodation.class);
        beanTester.testBean(Payment.class);
        beanTester.testBean(Place.class);
        beanTester.testBean(Room.class);
        beanTester.testBean(Transportation.class);
        beanTester.testBean(TripPlan.class);
        beanTester.testBean(Vehicle.class);
        beanTester.testBean(VisitingPlace.class);
    }
    @Test
    void TestAllDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(PaymentDTO.class);
        beanTester.testBean(PaymentResponseDTO.class);
        beanTester.testBean(TripPlanDTO.class);
    }
}
