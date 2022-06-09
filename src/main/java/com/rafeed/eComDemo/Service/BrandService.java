package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Brand;

import java.util.List;

public interface BrandService {
    public Brand saveBrand(Brand brand);

    public List<Brand> getAllBrands();
}
