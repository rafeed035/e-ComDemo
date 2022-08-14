package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Cart;

import java.util.List;

public interface CartService {

    Cart saveCart(Cart cart, int customerId, int productId);
    List<Cart> getCartsByCustomerId(int customerId);
}
