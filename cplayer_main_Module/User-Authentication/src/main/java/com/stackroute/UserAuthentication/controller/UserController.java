package com.stackroute.UserAuthentication.controller;

import com.stackroute.UserAuthentication.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthentication.model.userDao;
import com.stackroute.UserAuthentication.service.userServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private userServiceDAO service;
    @Autowired
    public UserController(userServiceDAO service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<userDao> getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<userDao>> getUserById(@PathVariable Long id){
        return new ResponseEntity<List<userDao>>(service.getUserById(id), HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<userDao> createUser(@Validated @RequestBody userDao daoUser) throws UserAlreadyExistsException {
        return new ResponseEntity<userDao>(service.createUser(daoUser), HttpStatus.OK);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }


    @PutMapping("userUpdate/{id}")
    public ResponseEntity<userDao> updateUser(@RequestBody userDao daoUser,@PathVariable Long id){
        return  new ResponseEntity<userDao>(service.updateUser(daoUser,id),HttpStatus.FOUND);
    }
}
