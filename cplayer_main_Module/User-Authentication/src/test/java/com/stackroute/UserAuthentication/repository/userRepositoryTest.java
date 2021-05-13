package com.stackroute.UserAuthentication.repository;

import com.stackroute.UserAuthentication.model.userDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class userRepositoryTest {
    @Autowired
    private userRepository repository;
    private userDao user;

    @BeforeEach
    public void setUp() {
        user = new userDao();
        user.setId(1);
        user.setFirstName("sheenuh");
        user.setLastName("ashim");
        user.setEmail("Sample@gmail.com");
        user.setAge(35);
        user.setPhoneNo("5564556");
        user.setPassword("pass");
    }
    @AfterEach
    public void tearDown() {
        repository.deleteAll();
        user = null;
    }
    @Test
    public void givenGetUserDetailsThenShouldReturnUserDetails() {
        userDao user = new userDao(2, "Demo2", "ashim", 23 , "Sample@gmail.com", "pass" , "123445" );
        userDao user1 = new userDao(3,"Demo3", "Imneet", 76 ,"Sample@gmail.com", "password" , "7856474" );
        List<userDao> userDaoList = (List<userDao>) repository.findAll();
        assertEquals("Demo2", user.getFirstName());
        assertEquals("Demo3", user1.getFirstName());
    }
    @Test
    public void givenUserIdThenShouldReturnRespectiveUser() {
        userDao user = new userDao(9, "Demo9", "Imneet", 66 ,"SampleB@gmail.com","phyu","1234");
        userDao user1 = repository.save(user);
        List<userDao> optional = repository.getUserById(user1.getId());
        assertEquals(user1.getId(), optional.get(0).getId());
        assertEquals(user1.getFirstName(), optional.get(0).getFirstName());
        assertEquals(user1.getLastName(), optional.get(0).getLastName());
        assertEquals(user1.getEmail(), optional.get(0).getEmail());
        assertEquals(user1.getPassword(), optional.get(0).getPassword());
        assertEquals(user1.getAge(), optional.get(0).getAge());
        assertEquals(user1.getPhoneNo(), optional.get(0).getPhoneNo());
    }
}