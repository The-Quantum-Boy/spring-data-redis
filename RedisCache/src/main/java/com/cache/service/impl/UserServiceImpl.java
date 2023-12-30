package com.cache.service.impl;

import com.cache.model.User;
import com.cache.repository.UserDao;
import com.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> fetchAll() {
        return userDao.fetchAllUser();
    }

    @Override
    public User fetchUserById(Long id) {
        return userDao.fetchUserById(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }
}
