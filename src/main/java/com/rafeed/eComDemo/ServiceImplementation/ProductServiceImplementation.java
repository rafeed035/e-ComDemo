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
        List<Brand> brands = brandRepository.getBrandsByCategory(category);
        Brand brandNew = product.getBrand();
        if(brands.size() > 0){
            for(int i=0; i<brands.size(); i++){
                if(brands.get(i).getBrandName().equals(product.getBrand().getBrandName())){
                    System.out.println("Brand already exists!");
                    brandNew.setCategory(category);
                    brandNew = brands.get(i);
                    product.setBrand(brandNew);
                    break;
                }
                else{
                    categoryRepository.save(product.getBrand().getCategory());
                    brandNew = product.getBrand();
                    brandRepository.save(brandNew);
                }
            }
        }
        else{
            brandNew = product.getBrand();
            brandRepository.save(brandNew);
        }

        //check if the product is already there in the product table
        Product productCheck = productRepository.getProductByProductName(product.getProductName());
        if(productCheck != null){
            System.out.println("Product already exists");
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
