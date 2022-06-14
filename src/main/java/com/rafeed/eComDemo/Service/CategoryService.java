package com.rafeed.eComDemo.Service;

import com.rafeed.eComDemo.Entity.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(Category category);

    public List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    Category getCategoryByName(String categoryName);
}
