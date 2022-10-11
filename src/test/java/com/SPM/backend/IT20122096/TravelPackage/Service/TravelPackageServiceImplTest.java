package com.SPM.backend.IT20122096.TravelPackage.Service;

import com.SPM.backend.IT20122096.CommonData;
import com.SPM.backend.IT20122096.Places.Repository.PlaceRepository;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Repository.TransportRepository;
import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import com.SPM.backend.IT20122096.TravelPackage.Repository.TravelPackageRepository;
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
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TravelPackageServiceImplTest {

    @Autowired
    TravelPackageServiceImpl travelPackageService;
    @MockBean
    TravelPackageRepository travelPackageRepository;
    @MockBean
    HotelRepository hotelRepository;
    @MockBean
    TransportRepository transportRepository;
    @MockBean
    PlaceRepository placeRepository;

    CommonData commonData = new CommonData();

    @Test
    void TestSaveNewPackage(){

        Mockito.when(travelPackageRepository.save(Mockito.any())).thenReturn(commonData.getPackage(4));

        ResponseEntity<?> result = travelPackageService.saveNewPackage(commonData.getPackageDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestUpdatePackageSuccess(){
        Mockito.when(travelPackageRepository.findById(Mockito.any())).thenReturn(Optional.of(commonData.getPackage(4)));
        Mockito.when(travelPackageRepository.save(Mockito.any())).thenReturn(commonData.getPackage(4));

        ResponseEntity<?> result = travelPackageService.updatePackage(commonData.getPackageDTO());
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());
    }
    @Test
    void TestUpdatePackageFailure(){
        Mockito.when(travelPackageRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        ResponseEntity<?> result = travelPackageService.updatePackage(commonData.getPackageDTO());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Package dose not exist", result.getBody());
    }
    @Test
    void TestGetAllPackages(){
        Hotel hotel = new Hotel();
        hotel.setName("TestHotel");
        hotel.setImageURL("HotelImageUrl");

        Transport transport = new Transport();
        transport.setName("TestTransport");
        transport.setImageURL("TransportImageUrl");

        com.SPM.backend.IT20122096.Places.Entity.Place place = new com.SPM.backend.IT20122096.Places.Entity.Place();
        place.setName("TestPlace");
        place.setImageURL("PlaceImageUrl");

        Mockito.when(travelPackageRepository.findAll()).thenReturn(commonData.getPackageList());
        Mockito.when(hotelRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(hotel));
        Mockito.when(transportRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(transport));
        Mockito.when(placeRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(place));

        ResponseEntity<?> result = travelPackageService.getAllPackages();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals(4,((List<TravelPackage>) Objects.requireNonNull(result.getBody())).size());

    }
    @Test
    void TestGetPackageByIdSuccess(){
        Hotel hotel = new Hotel();
        hotel.setName("TestHotel");
        hotel.setImageURL("HotelImageUrl");

        Transport transport = new Transport();
        transport.setName("TestTransport");
        transport.setImageURL("TransportImageUrl");

        com.SPM.backend.IT20122096.Places.Entity.Place place = new com.SPM.backend.IT20122096.Places.Entity.Place();
        place.setName("TestPlace");
        place.setImageURL("PlaceImageUrl");

        Mockito.when(travelPackageRepository.findById(Mockito.any())).thenReturn(Optional.of(commonData.getPackage(2)));
        Mockito.when(hotelRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(hotel));
        Mockito.when(transportRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(transport));
        Mockito.when(placeRepository.findById(new ObjectId("633372dc0a880e615b3efbce"))).thenReturn(Optional.of(place));

        ResponseEntity<?> result = travelPackageService.getPackageById(new ObjectId("633372dc0a880e615b3efbce"));
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("TestTransport",((TravelPackage) Objects.requireNonNull(result.getBody())).getTransportation().getName());


    }
    @Test
    void TestGetPackageByIdFailure(){
        Mockito.when(travelPackageRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        ResponseEntity<?> result = travelPackageService.getPackageById(new ObjectId("633372dc0a880e615b3efbce"));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Package dose not exist",result.getBody());
    }
    @Test
    void TestDeletePackageById(){
        ResponseEntity<?> result = travelPackageService.deletePackageById(new ObjectId("633372dc0a880e615b3efbce"));
        Assertions.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assertions.assertEquals("Deleted Successfully",result.getBody());
    }

}
