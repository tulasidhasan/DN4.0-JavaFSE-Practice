package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String alice);
}
