package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
