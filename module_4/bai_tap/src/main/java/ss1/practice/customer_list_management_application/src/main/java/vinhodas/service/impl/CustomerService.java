package vinhodas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinhodas.model.Customer;
import vinhodas.repository.ICustomerRepository;
import vinhodas.service.ICustomerSerice;

import java.util.List;

@Service
public class CustomerService implements ICustomerSerice {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> edit() {
        return null;
    }

    @Override
    public Customer findById() {
        return null;
    }
}
