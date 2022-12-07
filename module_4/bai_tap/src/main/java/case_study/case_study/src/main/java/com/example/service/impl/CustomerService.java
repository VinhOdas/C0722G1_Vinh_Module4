package com.example.service.impl;

import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.repository.ICustomerRepository;
import com.example.repository.ICustomerTypeRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Page<Customer> search(String searchName, Pageable pageable) {
        return customerRepository.findByName(searchName, pageable);
    }
}
