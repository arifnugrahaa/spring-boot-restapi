package com.restapi.Model.Repositories;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restapi.Model.Entities.Product;
import com.restapi.Model.Entities.Suplier;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
    List<Product> findByNameContains(String name);

    /**
     * JPAQL
     */
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findProductByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE :suplier MEMBER OF p.supliers")
    public List<Product> findProductBySuplier(@PathParam("suplier") Suplier suplier);
}
