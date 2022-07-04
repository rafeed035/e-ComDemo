package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;

import java.util.List;

public interface BrandService {
    //save brand
    Brand saveBrand(Brand brand);

    //get all brands
    List<Brand> getAllBrands();

    //get brand by brand id
    Brand getBrandById(int brandId);

    //get brand by brand name
    Brand getBrandByName(String brandName);

    //get brands by brand name
    List<Brand> getBrandsByName(String brandName);

    //get all the brands by category
    List<Brand> getBrandsByCategory(Category category);

    //get brand by category
    Brand getBrandByCategory(Category category);
}
