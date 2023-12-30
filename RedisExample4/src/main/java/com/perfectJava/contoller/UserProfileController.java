package com.perfectJava.contoller;

import com.perfectJava.entities.UserProfile;
import com.perfectJava.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileController {



    private Logger log= LoggerFactory.getLogger(UserProfileController.class);

    @Autowired
    private UserProfileService service;

    @GetMapping("/get/{id}")
    public UserProfile getUserProfile(@PathVariable Long id){
        service.getCache(id);
        return service.getUser(id);
    }

    @GetMapping("/get")
    public List<UserProfile> getAllProfile(){
        return service.getAllUser();
    }

    @PutMapping("/update")
    public UserProfile updateUserProfile(@RequestBody UserProfile userProfile){
        service.getCache(userProfile.getId());
        return service.updateUserProfile(userProfile);
    }

    @DeleteMapping("/delete/{id}")
    public void deletedUserProfile(@PathVariable Long id ){
        UserProfile user1 = service.getCache(id);
        System.out.println(user1);
        service.deleteUserProfile(id);
        UserProfile user = service.getCache(id);
        if(user==null){
            System.out.println("user not present");
        }else{
            System.out.println(user);
        }
    }

}
