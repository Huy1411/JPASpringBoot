package com.example.enterprise_application.service;


import com.example.enterprise_application.jpa.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role insertRole(Role role);
    Role getRoleById(int id);
    boolean update(Role role);
    boolean saveRole(Role role);
}
