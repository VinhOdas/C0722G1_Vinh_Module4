package vinhodas.service;

import vinhodas.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
