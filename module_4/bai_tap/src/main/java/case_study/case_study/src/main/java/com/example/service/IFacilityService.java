package com.example.service;


import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAllByNameAndType(String name, String type, Pageable pageable);
    List<Facility>findAll();
    void save(Facility facility);
    Optional<Facility> findById(int id);
    void remove(int id);
    List<FacilityType> findAllFacilityType();
    List<RentType> findAllRentType();
}
