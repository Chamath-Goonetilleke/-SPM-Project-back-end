package com.SPM.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
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

    private String companyEmailAddress;

    private String companyHotline;

    private String landTransport;

    private String airTransport;

    private String waterTransport;

    private String locations;

    private boolean isApproved;
}
