package com.example.demo.repository;

import com.example.demo.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Create and save test users
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Alice");

        userRepository.save(user1);
        userRepository.save(user2);

        // Find users by name
        List<User> result = userRepository.findByName("Alice");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(u -> "Alice".equals(u.getName())));
    }

    private void assertEquals(int i, int size) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void assertTrue(boolean allMatch) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
