package com.example.enterprise_application.service.Impl;


import com.example.enterprise_application.jpa.User;
import com.example.enterprise_application.repository.UserRepository;
import com.example.enterprise_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUsername(String email) {
        try{
            User user = userRepository.findByEmail(email);
            return user;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean saveUser2(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        try{
            List<User> listUser = userRepository.findAll();
            return listUser;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
