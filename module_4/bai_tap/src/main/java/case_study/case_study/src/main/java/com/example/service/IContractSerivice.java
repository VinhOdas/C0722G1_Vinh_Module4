package com.example.service;

import com.example.dto.IContractDto;
import com.example.model.contract.AttachFacility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractSerivice {
    Page<IContractDto> getListContract(Pageable pageable);

    List<AttachFacility> findAllAttachFacility();
}
