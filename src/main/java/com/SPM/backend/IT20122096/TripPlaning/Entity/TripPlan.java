package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class TripPlan {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private String name;
    private String type;
    private String startDate;
    private String endDate;
    private Place place;
    private Accommodation accommodation;
    private Transportation transportation;
    private double totalCost;
    private boolean isBooked=false;

}
