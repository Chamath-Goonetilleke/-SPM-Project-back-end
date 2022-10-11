package com.SPM.backend.IT20122096.TravelPackage.Entity_DTO;

import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TravelPackageEntityDTOTest {
    @Test
    void TestAllTravelPackageEntities(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(TravelPackage.class);
    }
    @Test
    void TestAllTravelPackageDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(TravelPackageDTO.class);
    }
}
