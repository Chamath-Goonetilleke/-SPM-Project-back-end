package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Payment {
    @Id
    private ObjectId id;
    private ObjectId tripPlanId;
    private ObjectId userId;
    private String type;
    private String date;
    private double amount;
}
