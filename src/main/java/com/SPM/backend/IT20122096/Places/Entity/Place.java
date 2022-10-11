package com.SPM.backend.IT20122096.Places.Entity;

import lombok.*;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    private ObjectId id;
    private String name;
    private String district;
    private String province;
    private String description;
    private String imageURL;
    private List<VisitingPlace> visitingPlaces;
}