package com.SPM.services;

import com.SPM.domains.TransportBusinessInformation;
import com.SPM.domains.TransportTypes;
import com.SPM.repository.TransportBusinessInformationRepository;
import com.SPM.repository.TransportTypesRepository;
import com.SPM.types.RecordStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TransportServices {

    TransportBusinessInformationRepository businessInformationRepository;
    TransportTypesRepository transportTypesRepository;

    @Autowired
    public TransportServices(TransportBusinessInformationRepository businessInformationRepository,
                             TransportTypesRepository transportTypesRepository) {
        this.businessInformationRepository = businessInformationRepository;
        this.transportTypesRepository = transportTypesRepository;
    }

    public List<TransportBusinessInformation> getAllTransportBusinessInformation() {
        return businessInformationRepository.findAll();
    }

    public TransportBusinessInformation getTransportBusinessInformation(String id) throws Exception {
        Optional<TransportBusinessInformation> businessInformation = businessInformationRepository.findById(id);
        if (businessInformation.isPresent()) {
            return businessInformation.get();
        } else {
            throw new Exception("Record not found");
        }
    }

    public TransportBusinessInformation addBusinessInformation(
            TransportBusinessInformation businessInformation) throws Exception {
        List<TransportBusinessInformation> list = businessInformationRepository.findAll();
        if (list.stream().anyMatch(o -> o.getCompanyEmail().equals(businessInformation.getCompanyEmail()))) {
            throw new Exception("Business already exists");
        }
        businessInformation.setIsApproved(RecordStatus.PENDING);
        return businessInformationRepository.save(businessInformation);
    }

    public List<TransportTypes> addTransportTypes(TransportTypes[] transportTypes) {
        return transportTypesRepository.saveAll(Arrays.asList(transportTypes));
    }

    public List<TransportBusinessInformation> searchTransportServices(String searchString) {
        return businessInformationRepository.findTransportBusinessInformationByCompanyNameLikeOrCompanyEmailLike(searchString, searchString);
    }

    public TransportBusinessInformation updateRecordStatus(String id, RecordStatus status) throws Exception {
        Optional<TransportBusinessInformation> businessInformation = businessInformationRepository.findById(id);

        if (businessInformation.isPresent()) {
            businessInformation.get().setIsApproved(status);
            return businessInformationRepository.save(businessInformation.get());
        } else {
            throw new Exception("Record not found");
        }
    }

}
