package com.restapi.Services;

import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restapi.Model.Entities.Category;
import com.restapi.Model.Repositories.CategoryRepo;

@Service
@TransactionScoped
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category){
        if(category.getId() != null){
            Category currentCategory = categoryRepo.findById(category.getId()).get();
            currentCategory.setName(category.getName());
            category = currentCategory;
        }
        return categoryRepo.save(category);
    }

    public Category findOne(Long id){
        Optional<Category> category = categoryRepo.findById(id);
        if(!category.isPresent()){
            return null;
        }
        return category.get();
    }

    public Iterable<Category> findAll(){
        return categoryRepo.findAll();
    }

    public void removeOne(Long id){
        categoryRepo.deleteById(id);
    }

    public Iterable<Category> findByName(String name, Pageable pageable){
        return categoryRepo.findByNameContains(name, pageable);
    }

    public Iterable<Category> saveBatch(Iterable<Category> categories){
        return categoryRepo.saveAll(categories);
    }
}
