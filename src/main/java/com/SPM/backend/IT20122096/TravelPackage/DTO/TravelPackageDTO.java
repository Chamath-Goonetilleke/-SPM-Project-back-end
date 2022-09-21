package com.SPM.backend.IT20122096.TravelPackage.DTO;

import com.SPM.backend.IT20122096.TripPlaning.Entity.Accommodation;
import com.SPM.backend.IT20122096.TripPlaning.Entity.Place;
import com.SPM.backend.IT20122096.TripPlaning.Entity.Transportation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
public class TravelPackageDTO {
    private ObjectId id;
    private String name;
    private String type;
    private Integer noOfDays;
    private Place place;
    private Accommodation accommodation;
    private Transportation transportation;
    private double totalCost;
    private Integer discount;
}
