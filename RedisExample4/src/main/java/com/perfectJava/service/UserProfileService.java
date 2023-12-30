package com.perfectJava.service;

import com.perfectJava.entities.UserProfile;
import com.perfectJava.repository.UserProfileRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    private Logger log= LoggerFactory.getLogger(UserProfileService.class);

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    CacheManager cacheManager;

    @Cacheable(cacheNames = "usersProfile",key = "#id", unless = "#result.follower < 20000")
    public UserProfile getUser(Long id){
        log.info("Getting user with id {}",id);

        Optional<UserProfile> user = userProfileRepo.findById(id);
        if(user.isPresent()){
            return userProfileRepo.findById(id).get();
        }

        return new UserProfile();
    }

    public List<UserProfile> getAllUser(){
        log.info("Getting all users");
        return userProfileRepo.findAll();
    }

    @CachePut(value = "usersProfile", key = "#user.id")
    public UserProfile updateUserProfile(UserProfile user){
        return userProfileRepo.save(user);
    }

    @CacheEvict(value = "usersProfile", key = "#id")
    public void deleteUserProfile(Long id){
        userProfileRepo.deleteById(id);
        log.info("User with id {} deleted.",id);
    }

    public UserProfile getCache(Long id){
        Cache cache = cacheManager.getCache("usersProfile");
        if (cache != null) {
            Cache.ValueWrapper valueWrapper = cache.get(id);
            if (valueWrapper != null) {
                UserProfile cachedUserProfile = (UserProfile) valueWrapper.get();
                System.out.println("Cached UserProfile: " + cachedUserProfile);
                return cachedUserProfile;
            }
        }
        return null;
    }

}
