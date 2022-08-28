package com.restapi.Model.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restapi.Model.Entities.Suplier;

public interface SuplierRepo extends CrudRepository<Suplier, Long> {
    
    Suplier findByEmail(String email);

    List<Suplier> findByNameContainsOrderByIdDesc(String name);

    List<Suplier> findByNameStartingWith(String prefix);

    List<Suplier> findByNameContainsOrEmailContains(String name, String email);
}
