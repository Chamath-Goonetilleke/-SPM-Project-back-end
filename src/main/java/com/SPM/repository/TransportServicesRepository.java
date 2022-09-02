package com.SPM.repository;

import com.SPM.domains.TransportServices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportServicesRepository extends MongoRepository<TransportServices, String> {
    List<TransportServices> findTransportBusinessInformationByCompanyNameLikeOrCompanyEmailLike(String companyName, String companyEmail);
}
