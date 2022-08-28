package com.restapi.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.Model.Entities.Suplier;
import com.restapi.Model.Repositories.SuplierRepo;

@Service
@Transactional
public class SuplierService {
    
    @Autowired
    private SuplierRepo suplierRepo;

    public Suplier save(Suplier suplier){
        return suplierRepo.save(suplier);
    }

    public Suplier findOne(Long id){
        Optional<Suplier> suplier = suplierRepo.findById(id);
        if(!suplier.isPresent()){
            return null;
        }
        return suplier.get();
    }

    public Iterable<Suplier> findAll(){
        return suplierRepo.findAll();
    }

    public void removeOne(Long id){
        suplierRepo.deleteById(id);
    }

    public Suplier findByEmail(String email){
        return suplierRepo.findByEmail(email);
    }

    public List<Suplier> findByName(String name){
        return suplierRepo.findByNameContainsOrderByIdDesc(name);
    }

    public List<Suplier> findByNameStartWith(String prefix){
        return suplierRepo.findByNameStartingWith(prefix);
    }

    public List<Suplier> findByNameOrEmail(String name, String email){
        return suplierRepo.findByNameContainsOrEmailContains(name, email);
    }
}
