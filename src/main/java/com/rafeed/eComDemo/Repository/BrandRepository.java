package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand getBrandByBrandId(int brandId);

    Brand getBrandByBrandName(String brandName);

    List<Brand> getBrandsByCategory(Category category);

    List<Brand> getBrandsByBrandName(String brandName);

    Brand getBrandByCategory(Category category);
}
