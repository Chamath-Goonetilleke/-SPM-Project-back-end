package com.SPM.services;

import com.SPM.domains.TransportServices;
import com.SPM.repository.TransportServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceTransportServices {
    TransportServicesRepository transportServicesRepository;

    @Autowired
    public ServiceTransportServices(TransportServicesRepository transportServicesRepository) {
        this.transportServicesRepository = transportServicesRepository;
    }

    public List<com.SPM.domains.TransportServices> getRequestedTransportServicesInformation() {
        List<com.SPM.domains.TransportServices> businesses = transportServicesRepository.findAll();
        return businesses.stream().filter(b -> !b.isApproved()).collect(Collectors.toList());
    }

    public List<com.SPM.domains.TransportServices> getRegisteredTransportServicesInformation() {
        List<com.SPM.domains.TransportServices> transportService = transportServicesRepository.findAll();
        return transportService.stream().filter(TransportServices::isApproved).collect(Collectors.toList());
    }

    public com.SPM.domains.TransportServices approveTransportService(String id) throws Exception {
        Optional<com.SPM.domains.TransportServices> transportService = transportServicesRepository.findById(id);
        if (transportService.isPresent()) {
            transportService.get().setApproved(true);
            return transportServicesRepository.save(transportService.get());
        } else {
            throw new Exception("Record not found");
        }
    }

    public void declineTransportService(String id) throws Exception {
        Optional<com.SPM.domains.TransportServices> transportService = transportServicesRepository.findById(id);
        if (transportService.isPresent()) {
            transportServicesRepository.deleteById(id);
        } else {
            throw new Exception("Record not found");
        }
    }

    public com.SPM.domains.TransportServices addTransportService(
            com.SPM.domains.TransportServices transportService) throws Exception {
        List<com.SPM.domains.TransportServices> list = transportServicesRepository.findAll();
        if (list.stream().anyMatch(o -> o.getCompanyEmailAddress().equals(transportService.getCompanyEmailAddress()))) {
            throw new Exception("Business already exists");
        }
        transportService.setApproved(false);
        return transportServicesRepository.save(transportService);
    }

    public List<com.SPM.domains.TransportServices> searchTransportServices(String searchString) {
        return transportServicesRepository.findTransportServicesByCompanyEmailAddressOrCompanyName(searchString, searchString);
    }

}
