package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transportation {

    private ObjectId id;
    private String numOfKilometers;
    private List<Vehicle> vehicles;
    private double total;
}
