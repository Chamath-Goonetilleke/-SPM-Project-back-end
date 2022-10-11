package com.SPM.backend.IT20122096.TravelPackage.Entity;

import com.SPM.backend.IT20122096.TripPlaning.Entity.Accommodation;
import com.SPM.backend.IT20122096.TripPlaning.Entity.Place;
import com.SPM.backend.IT20122096.TripPlaning.Entity.Transportation;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class TravelPackage {
    @Id
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
