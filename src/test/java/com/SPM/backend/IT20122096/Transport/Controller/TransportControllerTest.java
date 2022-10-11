package com.SPM.backend.IT20122096.Transport.Controller;

import com.SPM.backend.IT20122096.Transport.DTO.TransportDTO;
import com.SPM.backend.IT20122096.Transport.Service.TransportService;
import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
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
public class TransportControllerTest {

    @Autowired
    TransportController transportController;
    @MockBean
    TransportService transportService;

    @Test
    void TestSaveTransportService(){
        Mockito.when(transportService.saveTransportService(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = transportController.saveTransportService(new TransportDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetAllTransportServices(){
        Mockito.when(transportService.getAllTransportServices()).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = transportController.getAllTransportServices();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetTransportService(){
        Mockito.when(transportService.getTransportService(Mockito.any())).thenReturn(new ResponseEntity("TestPackage", HttpStatus.OK));
        ResponseEntity<?> result = transportController.getTransportService(new ObjectId());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }

}
