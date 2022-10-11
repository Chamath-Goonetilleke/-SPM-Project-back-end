package com.SPM.backend.IT20122096.TripPlaning.Entity;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private ObjectId id;
    private String name;
    private String image;
    private List<VisitingPlace> visitingPlaces;

}
