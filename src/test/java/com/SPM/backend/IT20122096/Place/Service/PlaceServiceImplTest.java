package com.SPM.backend.IT20122096.Place.Service;

import com.SPM.backend.IT20122096.CommonData;
import com.SPM.backend.IT20122096.Places.Repository.PlaceRepository;
import com.SPM.backend.IT20122096.Places.Service.PlaceServiceImpl;
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

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaceServiceImplTest {

    @Autowired
    PlaceServiceImpl placeService;
    @MockBean
    PlaceRepository placeRepository;

    CommonData commonData = new CommonData();
    @Test
    void TestSavePlace(){
        Mockito.when(placeRepository.save(Mockito.any())).thenReturn(commonData.getPlace());

        ResponseEntity<?> result = placeService.savePlace(commonData.getPlaceDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetAllPlaces(){

        Mockito.when(placeRepository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<?> result = placeService.getAllPlaces();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetPlaceByIdSuccess(){
        Mockito.when(placeRepository.findById(Mockito.any())).thenReturn(Optional.of(commonData.getPlace()));

        ResponseEntity<?> result = placeService.getPlaceById(new ObjectId("633372dc0a880e615b3efbce"));
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());

    }
    @Test
    void TestGetPlaceByIdFailure(){
        Mockito.when(placeRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        ResponseEntity<?> result = placeService.getPlaceById(new ObjectId("633372dc0a880e615b3efbce"));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Place dose not exist",result.getBody());

    }

}
