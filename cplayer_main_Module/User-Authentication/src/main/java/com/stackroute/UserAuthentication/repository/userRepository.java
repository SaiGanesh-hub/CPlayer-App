package com.stackroute.UserAuthentication.repository;

import com.stackroute.UserAuthentication.model.userDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends CrudRepository<userDao,Integer> {
    List<userDao> findByEmail(String email);
    userDao findByemail(String email);
    List<userDao> getUserById(Long id);
    //boolean  existBystdEmail(String email);
}
