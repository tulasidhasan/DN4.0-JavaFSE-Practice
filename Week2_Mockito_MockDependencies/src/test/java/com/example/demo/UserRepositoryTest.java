package com.example.demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Setup
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        User user3 = new User(3L, "Alice");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Act
        List<User> results = userRepository.findByName("Alice");

        // Assert
        assertEquals(2, results.size());
        assertTrue(results.stream().allMatch(u -> u.getName().equals("Alice")));
    }
}
