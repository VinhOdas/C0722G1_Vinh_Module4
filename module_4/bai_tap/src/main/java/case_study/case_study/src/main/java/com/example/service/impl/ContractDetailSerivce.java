package com.example.service.impl;

import com.example.model.contract.ContractDetail;
import com.example.repository.contract.ContractDetailRepository;
import com.example.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailSerivce implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
