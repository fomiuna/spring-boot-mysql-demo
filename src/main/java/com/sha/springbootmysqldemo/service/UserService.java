package com.sha.springbootmysqldemo.service;

import com.sha.springbootmysqldemo.model.User;
import com.sha.springbootmysqldemo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements IUserService
{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user)
    {
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }
}
