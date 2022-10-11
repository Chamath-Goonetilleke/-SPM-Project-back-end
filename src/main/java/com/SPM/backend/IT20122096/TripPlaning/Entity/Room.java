package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer roomNumber;
    private String roomType;
    private Integer capacity;
    private double price;
}
