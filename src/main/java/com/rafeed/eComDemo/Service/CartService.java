package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Cart;
import com.rafeed.eComDemo.Entity.Customer;

import java.util.List;

public interface CartService {

    Cart saveCart(Cart cart, int customerId, int productId);

    List<Cart> getCartsByCustomerId(int customerId);
}
