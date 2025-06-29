package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Arrange: Save some users
        User user1 = new User();
        user1.setName("Alice");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Bob");
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Alice");
        userRepository.save(user3);

        // Act
        List<User> usersNamedAlice = userRepository.findByName("Alice");

        // Assert
        assertEquals(2, usersNamedAlice.size());
        for (User user : usersNamedAlice) {
            assertEquals("Alice", user.getName());
        }
    }
}
