package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail (String username);
}
