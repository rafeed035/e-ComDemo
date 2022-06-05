package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(
         value = "select * from customer",
         nativeQuery = true
    )
    List<Customer> getAllCustomers();

//    List<Customer>getCustomersByCity();
}
