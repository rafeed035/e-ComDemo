package com.rafeed.eComDemo.Controller;

import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/allCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/getCategory")
    public Category getCategoryById(@RequestParam int categoryId){
        return categoryService.getCategoryById(categoryId);
    }
}
