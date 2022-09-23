package com.SPM.backend.IT20192082.model;

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

    private boolean favorite;

    private Object[] otherPlacesArray;

    public PlaceManagement() {

    }

    public PlaceManagement(String name, String image, String location, String rating, String description, float ratingCount, boolean approved, boolean favorite, Object[] otherPlacesArray) {
        this.name = name;
        this.image = image;
        this.location = location;
        this.rating = rating;
        this.description = description;
        this.ratingCount = ratingCount;
        this.approved = approved;
        this.favorite = favorite;
        this.otherPlacesArray = otherPlacesArray;
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

    public Object[] getOtherPlacesArray() {
        return otherPlacesArray;
    }

    public void setOtherPlacesArray(Object[] otherPlacesArray) {
        this.otherPlacesArray = otherPlacesArray;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
