package com.SPM.backend.IT20122096.Transport.Service;

import com.SPM.backend.IT20122096.CommonData;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
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
public class TransportServiceImplTest {

    @Autowired
    TransportServiceImpl transportService;
    @MockBean
    TransportRepository transportRepository;

    CommonData commonData = new CommonData();

    @Test
    void TestSaveTransportService(){
        Mockito.when(transportRepository.save(Mockito.any())).thenReturn(commonData.getTransport());

        ResponseEntity<?> result = transportService.saveTransportService(commonData.getTransportDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetAllTransportServices(){
        Mockito.when(transportRepository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<?> result = transportService.getAllTransportServices();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetTransportServiceSuccess(){
        Mockito.when(transportRepository.findById(new ObjectId("6331d725d613b66fd9db0f19"))).thenReturn(Optional.ofNullable(commonData.getTransport()));

        ResponseEntity<?> result = transportService.getTransportService(new ObjectId("6331d725d613b66fd9db0f19"));
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestGetTransportServiceFailure(){
        Mockito.when(transportRepository.findById(new ObjectId("6331d725d613b66fd9db0f19"))).thenReturn(Optional.empty());

        ResponseEntity<?> result = transportService.getTransportService(new ObjectId("6331d725d613b66fd9db0f19"));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Transport dose not exist",result.getBody());
    }

}
