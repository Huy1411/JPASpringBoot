package com.example.enterprise_application.repository;

import com.example.enterprise_application.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<
    Role,Integer> {
}
