package com.stackroute.UserAuthentication.service;


import com.stackroute.UserAuthentication.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthentication.model.userDao;
import com.stackroute.UserAuthentication.repository.userRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
    @Autowired
    private userRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public userDao save(userDao daoUser) throws UserAlreadyExistsException{

        List<userDao> byemail = userRepository.findByEmail(daoUser.getEmail());
        if(byemail!=null&& !byemail.isEmpty())
            throw new UserAlreadyExistsException("EmailId already exists","mailId already exists");
        String password= daoUser.getPassword();
        daoUser.setPassword(passwordEncoder.encode(password));


        return userRepository.save(daoUser);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        userDao user = userRepository.findByemail(email);
        logger.warn(user.toString());
        if(user==null){
            throw new UsernameNotFoundException("User not found" + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }
}
