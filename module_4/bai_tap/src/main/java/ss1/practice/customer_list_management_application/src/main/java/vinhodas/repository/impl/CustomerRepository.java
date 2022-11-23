package vinhodas.repository.impl;

import org.springframework.stereotype.Repository;
import vinhodas.model.Customer;
import vinhodas.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Vinh","gamquangvinh@gmail.com","Quang Binh"));
        customerList.add(new Customer(2,"Vinh1","gamquangvinh1@gmail.com","Quang Binh"));
        customerList.add(new Customer(3,"Vinh2","gamquangvinh2@gmail.com","Quang Binh"));
        customerList.add(new Customer(4,"Vinh3","gamquangvinh3@gmail.com","Quang Binh"));
    }
    @Override
    public List<Customer> findAll() {

        return customerList;
    }
}
