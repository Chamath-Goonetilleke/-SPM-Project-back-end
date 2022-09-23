package com.SPM.backend.IT20122096.Transport.DTO;

import com.SPM.backend.IT20122096.Transport.Entity.Vehicle;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;
@Data
public class TransportDTO {
    private ObjectId id;
    private String name;
    private String district;
    private String description;
    private String imageURL;
    private List<Vehicle> vehicles;
}
