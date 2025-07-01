package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser_Found() throws Exception {
        User mockUser = new User(1L, "Alice");
        when(userService.getUserById(1L)).thenReturn(mockUser);

        mockMvc.perform(get("/users/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    public void testGetUser_NotFound() throws Exception {
        when(userService.getUserById(2L)).thenReturn(null);

        mockMvc.perform(get("/users/2"))
               .andExpect(status().isNotFound());
    }
}
