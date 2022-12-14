package com.SPM.backend.IT20216078.repository;

import com.SPM.backend.IT20216078.domains.TransportServices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportServicesRepository extends MongoRepository<TransportServices, String> {
    List<TransportServices> findTransportServicesByCompanyEmailAddressContainsIgnoreCaseOrCompanyNameContainsIgnoreCase(String companyName, String companyEmail);

    TransportServices findTransportServicesByCompanyEmailAddress(String emailAddress);

    void deleteByCompanyEmailAddress(String emailAddress);
}
