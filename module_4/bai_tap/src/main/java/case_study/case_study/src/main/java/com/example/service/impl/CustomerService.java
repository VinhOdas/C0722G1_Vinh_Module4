package com.example.service.impl;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.repository.ICustomerRepository;
import com.example.repository.ICustomerTypeRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.remove(id);
    }

}
