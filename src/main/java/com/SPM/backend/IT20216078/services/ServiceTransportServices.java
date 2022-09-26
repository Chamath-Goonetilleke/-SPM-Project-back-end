package com.SPM.backend.IT20216078.services;

import com.SPM.backend.IT20216078.domains.TransportServices;
import com.SPM.backend.IT20216078.repository.TransportServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTransportServices {
    @Autowired
    TransportServicesRepository transportServicesRepository;

    @Autowired
    public ServiceTransportServices(TransportServicesRepository transportServicesRepository) {
        this.transportServicesRepository = transportServicesRepository;
    }

    public List<TransportServices> getRequestedTransportServicesInformation() {
        List<TransportServices> businesses = transportServicesRepository.findAll();
        return businesses.stream().filter(b -> !b.isApproved()).collect(Collectors.toList());
    }

    public List<TransportServices> getRegisteredTransportServicesInformation() {
        List<TransportServices> transportService = transportServicesRepository.findAll();
        return transportService.stream().filter(TransportServices::isApproved).collect(Collectors.toList());
    }

    public TransportServices approveTransportService(String emailAddress) {
        TransportServices transportService = transportServicesRepository.findTransportServicesByCompanyEmailAddress(emailAddress);
        transportService.setApproved(true);
        return transportServicesRepository.save(transportService);
    }

    public void declineTransportService(String emailAddress) {
        transportServicesRepository.deleteByCompanyEmailAddress(emailAddress);
    }

    public TransportServices addTransportService(TransportServices transportService) throws Exception {
        if (transportServicesRepository.findTransportServicesByCompanyEmailAddress(transportService.getCompanyEmailAddress()) != null) {
            if (!transportServicesRepository.findTransportServicesByCompanyEmailAddress(transportService.getCompanyEmailAddress()).isApproved()) {
                throw new Exception("Business not approved");
            } 
        } else {
            transportService.setApproved(false);
        }
        return transportServicesRepository.save(transportService);
    }

    public List<TransportServices> searchTransportServices(String searchString) {
        return transportServicesRepository.findTransportServicesByCompanyEmailAddressContainsIgnoreCaseOrCompanyNameContainsIgnoreCase(searchString, searchString);
    }

    public TransportServices searchTransportServiceByEmailAddress(String searchString) {
        return transportServicesRepository.findTransportServicesByCompanyEmailAddress((searchString));
    }
}
