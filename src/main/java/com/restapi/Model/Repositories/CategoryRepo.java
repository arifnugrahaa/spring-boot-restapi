package com.restapi.Model.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.restapi.Model.Entities.Category;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Long> {
    
    Page<Category> findByNameContains(String name, Pageable pageable);
}
