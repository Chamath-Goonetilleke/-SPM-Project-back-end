package com.SPM.backend.IT20122096.Places.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

@Data
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
;