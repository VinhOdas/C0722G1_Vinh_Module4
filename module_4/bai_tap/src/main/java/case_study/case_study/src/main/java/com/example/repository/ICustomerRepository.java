package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from Customer join CustomerType on " +
            "Customer.customerTypeId = CustomerType .id " +
            "where Customer.name like %:name% and Customer.deleteStatus=1 ",nativeQuery = true)
    Page<Customer> findByName(@Param("name") String searchName, Pageable pageable);
}
