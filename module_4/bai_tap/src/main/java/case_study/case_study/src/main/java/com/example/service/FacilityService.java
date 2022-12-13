package com.example.service;


import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.repository.facility.FacilityRepository;
import com.example.repository.facility.FacilityTypeRepository;
import com.example.repository.facility.RentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public Page<Facility> findAllByNameAndType(String name, String type, Pageable pageable) {
        return facilityRepository.findAllByNameAndType(name, type, pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        facilityRepository.remove(id);
    }

    @Override
    public List<FacilityType> findAllFacilityType() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }
}
