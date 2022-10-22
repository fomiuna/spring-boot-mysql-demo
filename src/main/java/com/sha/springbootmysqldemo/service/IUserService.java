package com.sha.springbootmysqldemo.service;

import com.sha.springbootmysqldemo.model.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAll();
}
