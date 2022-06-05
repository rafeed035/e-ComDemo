package com.rafeed.eComDemo.Service;
import com.rafeed.eComDemo.Entity.Customer;
import java.util.List;


public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public List<Customer> getAllCustomer();
}
