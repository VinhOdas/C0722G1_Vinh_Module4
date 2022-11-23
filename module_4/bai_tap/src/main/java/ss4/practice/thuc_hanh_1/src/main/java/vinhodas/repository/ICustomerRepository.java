package vinhodas.repository;

import vinhodas.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
