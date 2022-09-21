package com.SPM.backend.IT20122096.TripPlaning.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
    private String type;
    private String name;
    private String date;
    private double amount;
}
