package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getProductByBrand(String brandName);

    @Query(
            value = "select * from product p join brand b on p.brand_id = b.brand_id join category c on b.category_id = c.category_id where c.category_name = ?1",
            nativeQuery = true
    )
    List <Product> getProductByCategory(String categoryName);

    Product getProductByProductName(String productName);

    Product getProductByProductId(int productId);
}
