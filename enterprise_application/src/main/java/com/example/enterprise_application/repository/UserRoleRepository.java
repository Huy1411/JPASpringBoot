package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}

