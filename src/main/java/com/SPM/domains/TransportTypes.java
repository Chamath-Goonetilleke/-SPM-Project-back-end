package com.SPM.domains;

import com.SPM.types.Location;
import com.SPM.types.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transport_types")
@AllArgsConstructor
@Data
@ToString
public class TransportTypes {

    @Id
    String Id;

    VehicleType vehicleType;

    int noOfPassengers;

    float allowedWeightPerPassenger;

    Location[] locations;

    String paymentLink;

}
