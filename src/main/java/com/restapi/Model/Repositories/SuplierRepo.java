package com.restapi.Model.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.restapi.Model.Entities.Suplier;

public interface SuplierRepo extends CrudRepository<Suplier, Long> {
    
}
