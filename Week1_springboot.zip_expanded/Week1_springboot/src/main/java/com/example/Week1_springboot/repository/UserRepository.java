package com.example.Week1_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Week1_springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
