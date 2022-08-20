package com.restapi.Model.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.restapi.Model.Entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
