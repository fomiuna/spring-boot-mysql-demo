package com.sha.springbootmysqldemo.repository;

import com.sha.springbootmysqldemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long>
{
    //findBy + fieldName
    Optional<User> findByUsername(String username);
}
