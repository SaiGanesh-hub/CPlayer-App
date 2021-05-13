package com.stackroute.UserAuthentication.service;

import com.stackroute.UserAuthentication.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthentication.model.userDao;
import com.stackroute.UserAuthentication.repository.userRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class userServiceDAOTest {
    @Mock
    private userRepository repository;

    @InjectMocks
    private userServiceImpl userService;
    private userDao user,user1;
    private List<userDao> userServiceDAOListList;
    private Optional optional;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new userDao(2, "Blog", "John", 34, "Sampl@123.com", "pass", "48655");
        user1 = new userDao(2, "Blog", "John", 34, "Sampl@123.com", "pass", "48655");
    }
    @AfterEach
    public void tearDown() {
        user = null;
    }
    @Test
    public void givenUserToSaveThenShouldReturnSavedUser() {
        when(repository.save(any())).thenReturn(user);
        assertEquals(user, userService.createUser(user));
        // verify(repository, times(1)).save(any());
    }

}