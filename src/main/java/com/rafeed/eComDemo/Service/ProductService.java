package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Product;

import java.util.List;

public interface ProductService {

    //save new product
    public Product saveProduct(Product product);

    //get all the products
    public List<Product> getAllProducts();
}
