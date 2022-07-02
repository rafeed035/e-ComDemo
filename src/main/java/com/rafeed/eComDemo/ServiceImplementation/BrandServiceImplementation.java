package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Entity.Product;
import com.rafeed.eComDemo.Repository.BrandRepository;
import com.rafeed.eComDemo.Repository.CategoryRepository;
import com.rafeed.eComDemo.Repository.ProductRepository;
import com.rafeed.eComDemo.Service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImplementation implements BrandService {

    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;

    public BrandServiceImplementation(BrandRepository brandRepository,
                                      CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Brand saveBrand(Brand brand) {

        //check if the category already exists in the category table
        String categoryName = brand.getCategory().getCategoryName();
        Category categoryCheck = categoryRepository.getCategoryByCategoryName(categoryName);
        if(categoryCheck != null){
            brand.setCategory(categoryCheck);
        }
        else{
            categoryCheck = brand.getCategory();
            categoryRepository.save(brand.getCategory());
            brand.setCategory(categoryCheck);
        }

        //check if the brand with the specific category already exists in the brand table
        List<Brand> brands = brandRepository.getBrandsByCategory(brand.getCategory());
        Brand brandCheckByName = brandRepository.getBrandByBrandName(brand.getBrandName());
        if(brands.size() > 0){
            if(brandCheckByName != null){
                Category category = brandCheckByName.getCategory();
                if(category == brand.getCategory()){
                    System.out.println("brand already exists");
                }
                else{
                    brandCheckByName = brand;
                }
            }
            else{
                brandCheckByName = brand;
            }
        }
        else{
            brandCheckByName = brand;
        }
        return brandRepository.save(brandCheckByName);
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

    @Override
    public List<Brand> getBrandsByCategory(Category category) {
        return brandRepository.getBrandsByCategory(category);
    }

    @Override
    public Brand getBrandByCategory(Category category) {
        return brandRepository.getBrandByCategory(category);
    }
}
