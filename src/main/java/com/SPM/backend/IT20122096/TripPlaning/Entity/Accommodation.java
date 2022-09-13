package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {
    private ObjectId id;
    private Integer numOfMembers;
    private List<Room> rooms;
    private double total;
    private String image;
    private String name;

}

