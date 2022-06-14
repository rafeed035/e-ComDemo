package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Repository.BrandRepository;
import com.rafeed.eComDemo.Repository.CategoryRepository;
import com.rafeed.eComDemo.Service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImplementation implements BrandService {

    private BrandRepository brandRepository;

    public BrandServiceImplementation(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(int brandId) {
        return brandRepository.getBrandByBrandId(brandId);
    }

    @Override
    public Brand getBrandByName(String brandName) {
        return brandRepository.getBrandByBrandName(brandName);
    }
}
