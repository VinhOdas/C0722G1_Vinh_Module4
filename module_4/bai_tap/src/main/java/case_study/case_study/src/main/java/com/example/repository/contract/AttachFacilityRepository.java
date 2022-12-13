package com.example.repository.contract;

import com.example.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
