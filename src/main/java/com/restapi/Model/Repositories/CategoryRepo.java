package com.restapi.Model.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.restapi.Model.Entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    
}
