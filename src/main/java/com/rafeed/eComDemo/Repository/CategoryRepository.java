package com.rafeed.eComDemo.Repository;

import com.rafeed.eComDemo.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getCategoryByCategoryId(int categoryId);

    Category getCategoryByCategoryName(String categoryName);

    List<Category> getCategoriesByCategoryName(String categoryName);
}
