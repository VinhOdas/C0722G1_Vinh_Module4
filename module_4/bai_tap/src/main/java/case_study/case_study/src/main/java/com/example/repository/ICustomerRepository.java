package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = " select c.* from `customer` c  join  `customer_type` ct " +
            " on c.customer_type_id = ct.id " +
            "where c.name like %:name%", nativeQuery = true)
    Page<Customer> findByName(@Param("name") String searchName,
                              Pageable pageable);
}
