package vinhodas.service;

import vinhodas.model.Customer;

import java.util.List;

public interface ICustomerSerice {
    List<Customer> findAll();

    List<Customer> edit();

    Customer findById();

}
