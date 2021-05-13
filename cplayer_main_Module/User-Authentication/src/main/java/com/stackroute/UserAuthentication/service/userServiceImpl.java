package com.stackroute.UserAuthentication.service;

import com.stackroute.UserAuthentication.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthentication.model.userDao;
import com.stackroute.UserAuthentication.repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class userServiceImpl implements userServiceDAO{
    @Autowired
    private userRepository repository;

    @Override
    public userDao createUser(userDao daoUser)throws UserAlreadyExistsException {
        if(repository.existsById((int) daoUser.getId())){
            throw new UserAlreadyExistsException();
        }
        userDao student1 = repository.save(daoUser);
        return repository.save(student1);
    }

    @Override
    public List<userDao> getAllUsers() {
        return (List<userDao>) repository.findAll();
    }

    @Override
    public List<userDao> getUserById(Long id) {
        return getUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }

    @Override
    public userDao updateUser(userDao daoUser, Long id) {
        return repository.save(daoUser);
    }
}
