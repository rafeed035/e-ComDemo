package com.rafeed.eComDemo.Controller;

import com.rafeed.eComDemo.Entity.Cart;
import com.rafeed.eComDemo.Service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody Cart cart, @RequestParam int customerId, @RequestParam int productId){
        return cartService.saveCart(cart, customerId, productId);
    }

    @GetMapping("/getCartByCustomer")
    public List<Cart> getAllCartItems(int customerId){
        return cartService.getCartsByCustomerId(customerId);
    }
}
