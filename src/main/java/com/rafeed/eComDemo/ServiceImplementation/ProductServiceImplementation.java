package com.rafeed.eComDemo.ServiceImplementation;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Category;
import com.rafeed.eComDemo.Entity.Product;
import com.rafeed.eComDemo.Repository.BrandRepository;
import com.rafeed.eComDemo.Repository.CategoryRepository;
import com.rafeed.eComDemo.Repository.ProductRepository;
import com.rafeed.eComDemo.Service.ProductService;
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

        //check whether the category is already in the database or not
        String categoryName = product.getCategory().getCategoryName();
        Category category = categoryRepository.getCategoryByCategoryName(categoryName);

        if(category != null){
            product.setCategory(category);
        }
        else{
            product.setCategory(product.getCategory());
            categoryRepository.save(product.getCategory());

        }

        //check whether the brand is already in the database or not
        Brand brandCheck = brandRepository.getBrandByCategory(product.getCategory());
        if (brandCheck != null) {
            product.setBrand(brandCheck);
        } else {
            brandCheck = product.getBrand();
            brandRepository.save(brandCheck);
        }

        //check if the product is already there in the product table
        Product productCheck = productRepository.getProductByProductName(product.getProductName());
        if(productCheck != null){
            System.out.println("Already exists");
        }
        else{
            productCheck = product;
        }
        return productRepository.save(productCheck);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByBrand(String brandName) {
        return productRepository.getProductByBrand(brandName);
    }

    @Override
    public List<Product> getProductByCategory(String categoryName) {
        return productRepository.getProductByCategory(categoryName);
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.getProductByProductName(productName);
    }
}
