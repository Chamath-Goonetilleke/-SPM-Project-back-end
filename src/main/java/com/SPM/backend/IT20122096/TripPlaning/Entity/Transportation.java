package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transportation {

    private String driversName;
    private String vehicleNumber;
    private String vehicleCategory;
    private double feePerKilometer;
}
