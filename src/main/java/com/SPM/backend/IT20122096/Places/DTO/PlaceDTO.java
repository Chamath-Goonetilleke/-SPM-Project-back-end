package com.SPM.backend.IT20122096.Places.DTO;

import com.SPM.backend.IT20122096.Places.Entity.VisitingPlace;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class PlaceDTO {
    private ObjectId id;
    private String name;
    private String district;
    private String province;
    private String description;
    private String imageURL;
    private List<VisitingPlace> visitingPlaces;
}
