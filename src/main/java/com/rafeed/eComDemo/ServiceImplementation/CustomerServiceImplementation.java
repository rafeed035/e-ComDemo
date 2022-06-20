package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Customer;
import com.rafeed.eComDemo.Repository.CustomerRepository;
import com.rafeed.eComDemo.Service.CustomerService;
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

        //check if the customer is already in the customer table
        Customer customerCheck = customerRepository.getCustomersByPhone(customer.getPhone());
        if(customerCheck != null){
            System.out.println("Already exists");
        }
        else{
            customerCheck = customer;
        }
        return customerRepository.save(customerCheck);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        return customerRepository.getCustomersByPhone(phone);
    }
}
