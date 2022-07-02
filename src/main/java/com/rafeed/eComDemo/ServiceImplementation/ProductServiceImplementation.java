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

        //check whether the brand is already in the database or not
        Category category = categoryRepository.getCategoryByCategoryName(product.getBrand().getCategory().getCategoryName());
        Brand brandCheck = brandRepository.getBrandByCategory(category);
        if (brandCheck != null) {
            brandCheck.setCategory(category);
            product.setBrand(brandCheck);
        } else {
            categoryRepository.save(product.getBrand().getCategory());
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

    @Override
    public Product getProductById(int productId) {
        return productRepository.getProductByProductId(productId);
    }
}
