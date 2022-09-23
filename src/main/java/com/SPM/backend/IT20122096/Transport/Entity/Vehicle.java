package com.SPM.backend.IT20122096.Transport.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class Vehicle {


    private Long id=System.currentTimeMillis();
    private String type;
    private Integer capacity;
    private double price;

    public Vehicle(String type, Integer capacity, double price) {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
    }
}
