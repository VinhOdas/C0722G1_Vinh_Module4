package com.example.service;

import com.example.model.Customer;
import com.example.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    List<CustomerType> findAllCustomerType();

    Page<Customer> search(String searchName, Pageable pageable);
}
