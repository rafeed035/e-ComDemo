package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Entity.Product;
import com.rafeed.eComDemo.Repository.BrandRepository;
import com.rafeed.eComDemo.Repository.CategoryRepository;
import com.rafeed.eComDemo.Repository.ProductRepository;
import com.rafeed.eComDemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;
    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImplementation(ProductRepository productRepository,
                                        BrandRepository brandRepository,
                                        CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product saveProduct(Product product) {

        String brandName = product.getBrand().getBrandName();
        Brand brand = brandRepository.getBrandByBrandName(brandName);
        //check whether the brand is already in the database or not
        if(brand.equals(null)){
           product.setBrand(product.getBrand());
        }
        else{
            product.setBrand(brand);
        }

        String categoryName = product.getCategory().getCategoryName();
        Category category = categoryRepository.getCategoryByCategoryName(categoryName);

        //check whether the category is already in the database or not
        if(category.equals(null)){
            product.setCategory(product.getCategory());
        }
        else{
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
