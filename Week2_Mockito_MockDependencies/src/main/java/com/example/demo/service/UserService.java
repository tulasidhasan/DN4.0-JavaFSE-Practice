package com.example.demo.service;

import java.util.NoSuchElementException;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserByIdOrThrow(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("User not found"));
}


    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
    return userRepository.save(user);
}

    public void setUserRepository(UserRepository mockRepo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void getUserByIdOrThrow(long l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
