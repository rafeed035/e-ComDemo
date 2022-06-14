package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;

import java.util.List;

public interface BrandService {
    //save brand
    public Brand saveBrand(Brand brand);

    //get all brands
    public List<Brand> getAllBrands();

    Brand getBrandById(int brandId);

    Brand getBrandByName(String brandName);
}
