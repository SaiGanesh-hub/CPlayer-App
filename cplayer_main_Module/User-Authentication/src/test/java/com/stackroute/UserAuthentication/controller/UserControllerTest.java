package com.stackroute.UserAuthentication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.UserAuthentication.model.userDao;
import com.stackroute.UserAuthentication.service.userServiceDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    private MockMvc mockMvc;
    @Mock
    userServiceDAO userService;
    @InjectMocks
    private UserController userController;

    private userDao user;
    private List<userDao> UserList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new userDao();
        user.setId(1);
        user.setEmail("test@email.com");
        user.setFirstName("sheenu");
        user.setLastName("hashim");
        user.setAge(22);
        user.setPhoneNo("7856464");
        UserList = new ArrayList<>();
        UserList.add(user);
    }
    @AfterEach
    public void tearDown() {
        user = null;
    }
    @Test
    public void givenGetAllUsersThenShouldReturnListOfAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(UserList);
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andDo(MockMvcResultHandlers.print());
        verify(userService).getAllUsers();
        verify(userService, times(1)).getAllUsers();

    }
    @Test
    public void givenUserIdToDeleteThenShouldNotReturnDeletedUser() throws Exception {
        //  when(userService.deleteUser(user.getId()));
        System.out.println("givenUserIdToDeleteThenShouldNotReturnDeletedUser");
        mockMvc.perform(delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void givenUserToUpdateThenShouldReturnUpdatedUser() throws Exception {
        when(userService.updateUser(user , user.getId())).thenReturn(user);
        mockMvc.perform(put("/userUpdate/"+user.getId()).contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isFound()).andDo(MockMvcResultHandlers.print());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
