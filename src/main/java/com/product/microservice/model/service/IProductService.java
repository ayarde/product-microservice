package com.product.microservice.model.service;

import com.product.microservice.model.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findById(Long id);
}
