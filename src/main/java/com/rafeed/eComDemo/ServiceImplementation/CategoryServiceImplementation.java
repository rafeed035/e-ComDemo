package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Repository.CategoryRepository;
import com.rafeed.eComDemo.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
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
}
