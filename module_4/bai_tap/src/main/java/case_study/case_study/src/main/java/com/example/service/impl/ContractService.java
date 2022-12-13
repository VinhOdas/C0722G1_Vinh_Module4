package com.example.service.impl;

import com.example.dto.IContractDto;
import com.example.model.contract.AttachFacility;
import com.example.repository.contract.AttachFacilityRepository;
import com.example.repository.contract.ContractDetailRepository;
import com.example.repository.contract.ContractRepository;
import com.example.service.IContractSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractSerivice {
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Autowired
    AttachFacilityRepository attachFacilityRepository;


    @Override
    public Page<IContractDto> getListContract(Pageable pageable) {
        return contractRepository.showListContract(pageable);
    }

    @Override
    public List<AttachFacility> findAllAttachFacility() {
        return attachFacilityRepository.findAll();
    }
}
