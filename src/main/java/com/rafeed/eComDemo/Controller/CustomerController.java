package com.rafeed.eComDemo.Controller;

import com.rafeed.eComDemo.Entity.Customer;
import com.rafeed.eComDemo.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController{

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer>getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
