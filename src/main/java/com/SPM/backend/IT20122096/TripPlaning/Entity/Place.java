package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private String name;
    private String province;
    private String district;
    private List<String> visitingPlaces;

}
