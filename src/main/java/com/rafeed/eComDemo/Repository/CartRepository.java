package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Cart;
import com.rafeed.eComDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(
            value = "select * from cart where customer_id = ?1",
            nativeQuery = true
    )
    List<Cart> getCartsByCustomerId(int customerId);
}
