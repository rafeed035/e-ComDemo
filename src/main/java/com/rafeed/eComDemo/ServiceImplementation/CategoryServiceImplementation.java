package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Entity.Product;
import com.rafeed.eComDemo.Repository.BrandRepository;
import com.rafeed.eComDemo.Repository.CategoryRepository;
import com.rafeed.eComDemo.Repository.ProductRepository;
import com.rafeed.eComDemo.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private CategoryRepository categoryRepository;
    private BrandRepository brandRepository;
    private ProductRepository productRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository,
                                         BrandRepository brandRepository,
                                         ProductRepository productRepository
                                         ) {
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category saveCategory(Category category) {

        //check if the category already exists in the category table
        String categoryName = category.getCategoryName();
        Category categoryCheck = categoryRepository.getCategoryByCategoryName(categoryName);
        if(categoryCheck != null){
            System.out.println("Category already exists");
        }
        else{
            categoryCheck = category;
        }
        return categoryRepository.save(categoryCheck);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.getCategoryByCategoryId(categoryId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.getCategoryByCategoryName(categoryName);
    }

    @Override
    public List<Category> getCategoriesByName(String categoryName) {
        return categoryRepository.getCategoriesByCategoryName(categoryName);
    }
}
