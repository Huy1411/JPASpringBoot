package com.example.enterprise_application.service;


import com.example.enterprise_application.jpa.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String email);
    Boolean saveUser2(User user);
    List<User> getAllUser();
}
