package com.SPM.backend.IT20122096.TripPlaning.DTO;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private ObjectId id;
    private ObjectId tripPlanId;
    private String type;
    private String date;
    private ObjectId userId;
    private double amount;
}
