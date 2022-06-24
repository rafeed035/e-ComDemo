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
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public BrandServiceImplementation(BrandRepository brandRepository,
                                      ProductRepository productRepository,
                                      CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
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
            categoryRepository.save(categoryCheck);
            brand.setCategory(categoryCheck);
        }

        //check if the brand already exists in the brand table
        Brand brandCheck = brandRepository.getBrandByCategory(categoryCheck);
        if(brandCheck != null){
            System.out.println("Brand Already exist");
        }
        else{
            brandCheck = brand;
        }
        return brandRepository.save(brandCheck);
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
