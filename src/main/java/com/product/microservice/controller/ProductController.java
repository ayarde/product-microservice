package com.product.microservice.controller;
import com.product.microservice.model.entity.Product;
import com.product.microservice.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/list")
    public List<Product> list(){
        return productService.findAll().stream().map(product -> {
            //product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            product.setPort(port);
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/show/{id}")
    public Product detail(@PathVariable Long id) {
        Product product = productService.findById(id);
        boolean ok = false;
        //product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        product.setPort(port);

        /*try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return product;
    }

}
