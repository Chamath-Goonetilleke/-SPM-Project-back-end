package com.SPM.domains;

import com.SPM.types.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business_information")
@AllArgsConstructor
@Data
@ToString
public class TransportServices {
    @Id
    private String id;

    private String companyName;

    private String companyAddress;

    private String companyEmail;

    private String companyHotline;

    private RecordStatus isApproved;

    private String landTransport;

    private String airTransport;

    private String waterLocations;

    private String locations;
}
