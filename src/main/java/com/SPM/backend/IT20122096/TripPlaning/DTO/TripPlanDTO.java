package com.SPM.backend.IT20122096.TripPlaning.DTO;

import com.SPM.backend.IT20122096.TripPlaning.Entity.Accommodation;
import com.SPM.backend.IT20122096.TripPlaning.Entity.Place;
import com.SPM.backend.IT20122096.TripPlaning.Entity.Transportation;
import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripPlanDTO {
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
    private boolean isBooked = false;
}
