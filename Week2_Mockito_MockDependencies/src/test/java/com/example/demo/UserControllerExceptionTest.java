package com.example.demo;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.UserController;
import com.example.demo.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testUserNotFoundExceptionHandled() throws Exception {
        when(userService.getUserById(999L)).thenThrow(new NoSuchElementException());

        mockMvc.perform(get("/users/999")
                .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound())
               .andExpect(content().string("User not found"));
    }
}
