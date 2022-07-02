package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Product;

import java.util.List;
import java.util.PrimitiveIterator;

public interface ProductService {

    //save new product
    Product saveProduct(Product product);

    //get all the products
    List<Product> getAllProducts();

    //get product by product brand name
    List<Product> getProductByBrand(String brandName);

    //get product by brand name and category name
    List<Product> getProductByCategory(String categoryName);

    //get product by product name
    Product getProductByName(String productName);

    //get product by product id
    Product getProductById(int productId);
}
