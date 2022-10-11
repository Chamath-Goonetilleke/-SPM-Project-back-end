package com.SPM.backend.IT20122096.Place.Entity_DTO;

import com.SPM.backend.IT20122096.Places.DTO.PlaceDTO;
import com.SPM.backend.IT20122096.Places.Entity.Place;
import com.SPM.backend.IT20122096.Places.Entity.VisitingPlace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class PlaceEntityDtoTest {
    @Test
    void TestAllTravelPackageEntities(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Place.class);
        beanTester.testBean(VisitingPlace.class);
    }
    @Test
    void TestAllTravelPackageDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(PlaceDTO.class);
    }
}
