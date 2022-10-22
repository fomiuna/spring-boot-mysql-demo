package com.sha.springbootmysqldemo.controller;

import com.sha.springbootmysqldemo.model.User;
import com.sha.springbootmysqldemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")//pre-path for all methods
public class UserController
{
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user)//should be dto object
    {
        if(userService.findByUsername(user.getUsername()) != null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers()
    {
        return ResponseEntity.ok(userService.findAll());
    }
}
