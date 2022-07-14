package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Cart;
import com.rafeed.eComDemo.Entity.Customer;
import com.rafeed.eComDemo.Entity.Product;
import com.rafeed.eComDemo.Repository.CartRepository;
import com.rafeed.eComDemo.Repository.CustomerRepository;
import com.rafeed.eComDemo.Repository.ProductRepository;
import com.rafeed.eComDemo.Service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public CartServiceImplementation(CartRepository cartRepository,
                                     CustomerRepository customerRepository,
                                     ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart saveCart(Cart cart, int customerId, int productId) {
        Customer customer = customerRepository.getCustomersByCustomerId(customerId);
        Product product = productRepository.getProductByProductId(productId);
        cart.setCustomer(customer);
        cart.setProduct(product);
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartsByCustomerId(int customerId) {
        return cartRepository.getCartsByCustomerId(customerId);
    }
}
