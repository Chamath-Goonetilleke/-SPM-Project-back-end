package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transportation {

    private ObjectId id;
    private String name;
    private String image;
    private String numOfKilometers;
    private List<Vehicle> vehicles;
    private double total;
}
