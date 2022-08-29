package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {
    private String name;
    private Integer numOfMembers;
    private List<Room> rooms;
    private String checkingDate;
    private String checkoutDate;

}

