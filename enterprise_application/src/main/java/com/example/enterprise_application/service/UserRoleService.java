package com.example.enterprise_application.service;

import com.example.enterprise_application.jpa.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAllRole();
    boolean saveRole(UserRole userRole);
    UserRole getRoleById(int id);
    boolean editRole(UserRole userRole);
    boolean deleteRole(int id);
}
