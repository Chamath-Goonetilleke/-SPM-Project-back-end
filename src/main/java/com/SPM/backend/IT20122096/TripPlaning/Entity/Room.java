package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer roomNumber;
    private String category;
    private Integer capacity;
    private double price;
}
