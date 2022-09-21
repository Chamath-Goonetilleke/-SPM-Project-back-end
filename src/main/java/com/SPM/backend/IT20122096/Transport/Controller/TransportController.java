package com.SPM.backend.IT20122096.Transport.Controller;

import com.SPM.backend.IT20122096.Common.BaseController;
import com.SPM.backend.IT20122096.Transport.DTO.TransportDTO;
import com.SPM.backend.IT20122096.Transport.Service.TransportService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransportController extends BaseController {

    private TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping("/transport/save")
    ResponseEntity saveTransportService(@RequestBody TransportDTO transportDTO){
        return  transportService.saveTransportService(transportDTO);
    }
    @GetMapping("/transport/getAll")
    ResponseEntity getAllTransportServices(){
        return transportService.getAllTransportServices();
    }
    @GetMapping("/transport/{id}")
    ResponseEntity getTransportService(@PathVariable ObjectId id){
        return transportService.getTransportService(id);
    }

}
