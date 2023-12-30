package com.cache.service;

import com.cache.model.User;

import java.util.List;

public interface UserService {
    boolean save(User user);

    List<User> fetchAll();

    User fetchUserById(Long id);

    boolean deleteUserById(Long id);
}
