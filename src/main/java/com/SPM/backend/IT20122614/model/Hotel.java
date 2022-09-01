package com.SPM.backend.IT20122614.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String type;
    private String name;
    private String description;
    private String address;
    private String city;
    private String imageURL;
    private String roomType;
    private String facilities;
    private float price;

    public Hotel() {
    }

    public Hotel(String type, String name, String description, String address, String city, String imageURL, String roomType, String facilities, float price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.imageURL = imageURL;
        this.roomType = roomType;
        this.facilities = facilities;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
