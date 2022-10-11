package com.SPM.backend.IT20122096.Place.Controller;

import com.SPM.backend.IT20122096.Places.Controller.PlaceController;
import com.SPM.backend.IT20122096.Places.DTO.PlaceDTO;
import com.SPM.backend.IT20122096.Places.Service.PlaceService;
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
public class PlaceControllerTest {

    @Autowired
    PlaceController placeController;
    @MockBean
    PlaceService placeService;

    @Test
    void TestSavePlace(){
        Mockito.when(placeService.savePlace(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = placeController.savePlace(new PlaceDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetAllPlaces(){
        Mockito.when(placeService.getAllPlaces()).thenReturn(new ResponseEntity("TestPackages", HttpStatus.OK));
        ResponseEntity<?> result = placeController.getAllPlaces();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetPlaceById(){
        Mockito.when(placeService.getPlaceById(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = placeController.getPlaceById(new ObjectId());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }

}
