package com.SPM.backend.IT20122614.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Document("hotel")
public class Hotel {

    @Field(name = "type")
    private String type;

    @Field(name = "name")
    @Id
    private String name;
    @Field(name = "description")
    private String description;
    @Field(name = "address")
    private String address;
    @Field(name = "city")
    private String city;
    @Field(name = "imageURL")
    private String imageURL;

    @Field(name = "rooms")
    private Room[] room;

    public Hotel() {
    }

    public Hotel(String type, String name, String description, String address, String city, String imageURL, Room[] room) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.imageURL = imageURL;
        this.room = room;
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

    public Room[] getRoom() {
        return room;
    }

    public void setRoom(Room[] room) {
        this.room = room;
    }
}

