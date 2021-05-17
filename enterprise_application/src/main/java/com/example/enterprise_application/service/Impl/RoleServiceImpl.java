package com.example.enterprise_application.service.Impl;

import com.example.enterprise_application.jpa.Role;
import com.example.enterprise_application.repository.RoleRepository;
import com.example.enterprise_application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        try{
            List<Role> listRole = roleRepository.findAll();
            return  listRole;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role insertRole(Role role) {
        try{
            roleRepository.save(role);
            return role;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role getRoleById(int id) {
        try{
            Role role = roleRepository.findById(id).get();
            return  role;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Role role) {
        try{
            roleRepository.save(role);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveRole(Role role) {
        try{
            roleRepository.save(role);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
