package com.SPM.backend.IT20122096.Places.DTO;

import com.SPM.backend.IT20122096.Places.Entity.VisitingPlace;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class PlaceDTO {
    private ObjectId id;
    private String name;
    private String district;
    private String province;
    private String description;
    private String imageURL;
    private List<VisitingPlace> visitingPlaces;
}
