package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand getBrandByBrandId(int brandId);

    Brand getBrandByBrandName(String brandName);
}
