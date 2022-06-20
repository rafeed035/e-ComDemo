package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getProductByBrand(String brandName);

    List <Product> getProductByCategory(String categoryName);

    Product getProductByProductName(String productName);
}
