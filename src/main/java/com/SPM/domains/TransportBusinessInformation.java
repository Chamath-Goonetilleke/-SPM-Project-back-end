package com.SPM.domains;

import com.SPM.types.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "business_information")
@AllArgsConstructor
@Data
@ToString
public class TransportBusinessInformation {

    @Id
    private String id;

    private String companyName;

    private String companyAddress;

    private String companyEmail;

    private String companyHotline;

    private RecordStatus isApproved;

    @DBRef
    private List<TransportTypes> transportTypes;

}
