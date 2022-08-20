package com.restapi.Model.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restapi.Model.Entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
    List<Product> findByNameContains(String name);
}
