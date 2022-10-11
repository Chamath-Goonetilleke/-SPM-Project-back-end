package com.SPM.backend.IT20122096.TravelPackage.Controller;

import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import com.SPM.backend.IT20122096.TravelPackage.Service.TravelPackageService;
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

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TravelPackageControllerTest {

    @Autowired
    TravelPackageController travelPackageController;

    @MockBean
    TravelPackageService travelPackageService;

    @Test
    void TestSaveNewPackage(){
        Mockito.when(travelPackageService.saveNewPackage(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = travelPackageController.saveNewPackage(new TravelPackageDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestUpdatePackage(){
        Mockito.when(travelPackageService.updatePackage(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = travelPackageController.updatePackage(new TravelPackageDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetAllPackages(){
        Mockito.when(travelPackageService.getAllPackages()).thenReturn(new ResponseEntity("TestPackages", HttpStatus.OK));
        ResponseEntity<?> result = travelPackageController.getAllPackages();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetPackageById(){
        Mockito.when(travelPackageService.getPackageById(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = travelPackageController.getPackageById(new ObjectId());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestDeletePackageById(){
        Mockito.when(travelPackageService.deletePackageById(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = travelPackageController.deletePackageById(new ObjectId());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }

}
