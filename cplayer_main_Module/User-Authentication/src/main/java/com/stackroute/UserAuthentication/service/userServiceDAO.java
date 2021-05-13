package com.stackroute.UserAuthentication.service;

import com.stackroute.UserAuthentication.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthentication.model.userDao;

import java.util.List;

public interface userServiceDAO {
    userDao createUser(userDao daoUser) throws UserAlreadyExistsException;
    List<userDao> getAllUsers();
    List<userDao> getUserById(Long id);
    void deleteUser(Long id);
    userDao updateUser( userDao daoUser,Long id);
}
