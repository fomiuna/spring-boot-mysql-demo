package com.sha.springbootmysqldemo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="create_time")
    private LocalDateTime createTime;
}
