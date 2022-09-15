package com.SPM.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "placeManagement")
public class PlaceManagement {
    @Id
    private String id;
    private String name;
    private String image;
    private String location;
    private String rating;
    private String description;

    private float ratingCount;

    private boolean approved;

    public PlaceManagement() {

    }

    public PlaceManagement(String name, String image, String location, String rating, String description, float ratingCount, boolean approved) {
        this.name = name;
        this.image = image;
        this.location = location;
        this.rating = rating;
        this.description = description;
        this.ratingCount = ratingCount;
        this.approved = approved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PlaceManagement [id=" + id + ", name=" + name + ", image=" + image + ", location=" + location + ", rating=" + rating + ", description=" + description +"]";
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public float getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(float ratingCount) {
        this.ratingCount = ratingCount;
    }
}
