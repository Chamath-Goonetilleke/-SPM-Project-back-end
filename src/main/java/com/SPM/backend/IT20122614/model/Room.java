package com.SPM.backend.IT20122614.model;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {


    @Field(name = "roomType")
    private String roomType;
    @Field(name = "capacity")
    private int capacity;
    @Id
    @Field(name = "roomNumber")
    private int roomNumber;
    @Field(name = "facilities")
    private String facilities[];
    @Field(name = "price")
    private float price;

    public Room() {
    }

    public Room(String roomType, int capacity, int roomNumber, String[] facilities, float price) {
        this.roomType = roomType;
        this.capacity = capacity;
        this.roomNumber = roomNumber;
        this.facilities = facilities;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
