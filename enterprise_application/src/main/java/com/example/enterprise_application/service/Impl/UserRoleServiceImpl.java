package com.example.enterprise_application.service.Impl;


import com.example.enterprise_application.jpa.UserRole;
import com.example.enterprise_application.repository.UserRoleRepository;
import com.example.enterprise_application.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> getAllRole() {
        try{
            List<UserRole> list = userRoleRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveRole(UserRole userRole) {
        try{
            userRoleRepository.save(userRole);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public UserRole getRoleById(int id) {
        try{
            UserRole userRole = userRoleRepository.findById(id).get();
            return userRole;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editRole(UserRole userRole) {
        try{
            userRoleRepository.save(userRole);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRole(int id) {
        try{
            userRoleRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
