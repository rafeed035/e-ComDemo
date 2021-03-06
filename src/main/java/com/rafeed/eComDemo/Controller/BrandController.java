package com.rafeed.eComDemo.Controller;

import com.rafeed.eComDemo.Entity.Brand;
import com.rafeed.eComDemo.Service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    //add new brand
    @PostMapping("/addBrand")
    public Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    //get all the brands
    @GetMapping("/getAllBrands")
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping("/getBrand")
    public Brand getBrandById(@RequestParam int brandId){
        return brandService.getBrandById(brandId);
    }
}
