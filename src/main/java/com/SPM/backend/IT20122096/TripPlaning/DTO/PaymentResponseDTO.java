package com.SPM.backend.IT20122096.TripPlaning.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
    private String type;
    private String name;
    private String date;
    private double amount;
}
