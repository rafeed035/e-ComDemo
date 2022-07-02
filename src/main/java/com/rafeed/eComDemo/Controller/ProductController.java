package com.rafeed.eComDemo.Controller;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Entity.Product;
import com.rafeed.eComDemo.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProductsByCategory")
    public List<Product> getProductsByCategory(@RequestParam String categoryName){
        return productService.getProductByCategory(categoryName);
    }

    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam int productId){
        return productService.getProductById(productId);
    }

}
