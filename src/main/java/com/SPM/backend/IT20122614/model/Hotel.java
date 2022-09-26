package com.SPM.backend.IT20122614.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Document("hotel")
@Data
@AllArgsConstructor
public class Hotel {

    @Id
    private ObjectId id;
    @Field(name = "type")
    private String type;

    @Field(name = "name")

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


}

