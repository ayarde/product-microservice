package com.product.microservice.model.dao;

import com.microservice.common.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Long> {
}
