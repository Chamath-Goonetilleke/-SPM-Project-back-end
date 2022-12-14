package com.SPM.backend.IT20122096.TripPlaning.DTO;

import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import com.SPM.backend.IT20122096.TripPlaning.Entity.TripPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class BookingsDTO {
    List<TripPlan> tripPlans;
    List<TravelPackage> travelPackages;
}
