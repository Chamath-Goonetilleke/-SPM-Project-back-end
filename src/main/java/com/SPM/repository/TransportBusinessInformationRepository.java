package com.SPM.repository;

import com.SPM.domains.TransportBusinessInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportBusinessInformationRepository extends
        MongoRepository<TransportBusinessInformation, String> {

    List<TransportBusinessInformation> findTransportBusinessInformationByCompanyNameLikeOrCompanyEmailLike(String companyName, String companyEmail);

}
