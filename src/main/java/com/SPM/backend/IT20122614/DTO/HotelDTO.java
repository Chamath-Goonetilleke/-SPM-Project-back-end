package com.SPM.backend.IT20122614.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelDTO {
    private ObjectId id;
    private String type;
    private String name;
    private String description;
    private String address;
    private String city;
    private String imageURL;
    private String roomType;
    private String facilities;
    private float price;

}
