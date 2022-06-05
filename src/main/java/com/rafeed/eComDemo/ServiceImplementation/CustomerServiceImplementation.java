package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Customer;
import com.rafeed.eComDemo.Repository.CustomerRepository;
import com.rafeed.eComDemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomers();
    }
}
