package com.example.demo;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceTest {

    @Test
    public void testGetUserById_UserNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(999L)).thenReturn(Optional.empty());

        UserService service = new UserService();
        service.userRepository = mockRepo;

        assertThrows(NoSuchElementException.class, () -> {
            service.getUserById(999L);
        });
    }
}
