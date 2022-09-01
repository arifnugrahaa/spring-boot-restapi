package com.restapi.Model.Repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.restapi.Model.Entities.AppUser;

public interface AppUserRepo extends PagingAndSortingRepository<AppUser, Long> {
    
    Optional<AppUser> findByEmail(String email);
}
