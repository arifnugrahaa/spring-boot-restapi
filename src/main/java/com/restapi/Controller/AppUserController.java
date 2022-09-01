package com.restapi.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.Dto.AppUserData;
import com.restapi.Dto.ResponseData;
import com.restapi.Model.Entities.AppUser;
import com.restapi.Services.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData){
        
        ResponseData<AppUser> response = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        response.setPayload(appUserService.registerUser(appUser));
        response.setStatus(true);
        response.getMessage().add("AppUser Saved!!");
        return ResponseEntity.ok(response);
    }   
}
