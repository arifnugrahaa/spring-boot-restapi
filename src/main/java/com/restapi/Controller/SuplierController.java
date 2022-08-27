package com.restapi.Controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.Dto.ResponseData;
import com.restapi.Dto.SuplierData;
import com.restapi.Model.Entities.Suplier;
import com.restapi.Services.SuplierService;

@RestController
@RequestMapping("/api/suplier")
public class SuplierController {
    
    @Autowired
    private SuplierService suplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Suplier>> create(@Valid @RequestBody SuplierData suplierData, Errors errors){
        ResponseData<Suplier> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        //Dengan DTO
        // Suplier suplier = new Suplier();
        // suplier.setName(suplierData.getName());
        // suplier.setAddress(suplierData.getAddress());
        // suplier.setEmail(suplierData.getEmail());

        /**
         * Menggunakan model mapper
         * dengan syarat ada kemiripan antara entity dan dto
         */        
        Suplier suplier = modelMapper.map(suplierData, Suplier.class);

        responseData.setStatus(true);
        responseData.setPayload(suplierService.save(suplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Suplier> findAll(){
        return suplierService.findAll();
    }

    @GetMapping("/{id}")
    public Suplier findOne(@PathVariable("id") Long id){
        return suplierService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Suplier>> update(@Valid @RequestBody SuplierData suplierData, Errors errors){
        ResponseData<Suplier> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        //Dengan DTO
        // Suplier suplier = new Suplier();
        // suplier.setName(suplierData.getName());
        // suplier.setAddress(suplierData.getAddress());
        // suplier.setEmail(suplierData.getEmail());;

        /**
         * Menggunakan model mapper
         * dengan syarat ada kemiripan antara entity dan dto
         */        
        Suplier suplier = modelMapper.map(suplierData, Suplier.class);

        responseData.setStatus(true);
        responseData.setPayload(suplierService.save(suplier));
        return ResponseEntity.ok(responseData);
    }
}
