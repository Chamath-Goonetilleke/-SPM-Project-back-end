package com.SPM.backend.IT20122096.Transport.Service;

import com.SPM.backend.IT20122096.Transport.DTO.TransportDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

public interface TransportService {

    ResponseEntity saveTransportService(TransportDTO transportDTO);
    ResponseEntity getAllTransportServices();
    ResponseEntity getTransportService(ObjectId id);

}
