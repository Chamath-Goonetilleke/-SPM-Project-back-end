package com.SPM.backend.IT20122096.Transport.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    @Id
    private ObjectId id;
    private String name;
    private String district;
    private String description;
    private String imageURL;
    private List<Vehicle> vehicles;



}
