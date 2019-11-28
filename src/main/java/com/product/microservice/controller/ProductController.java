package com.product.microservice.controller;
import com.product.microservice.model.entity.Product;
import com.product.microservice.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/show/{id}")
    public Product detail(@PathVariable Long id){
        return productService.findById(id);
    }

}
