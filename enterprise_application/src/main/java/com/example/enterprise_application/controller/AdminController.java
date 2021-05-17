package com.example.enterprise_application.controller;


import com.example.enterprise_application.jpa.Role;
import com.example.enterprise_application.jpa.User;
import com.example.enterprise_application.jpa.UserRole;
import com.example.enterprise_application.service.RoleService;
import com.example.enterprise_application.service.UserRoleService;
import com.example.enterprise_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;
//    @RequestMapping("")
//    public String home(Model model)
//    {
//        return "admin/home";
//    }
    @RequestMapping(path = "/login")
    public String loginAdmin()
    {
        boolean bl = checkUser();
        if (bl==false)
        {
            createUserAdmin();
        }
        return "admin/user/login";
    }

    @RequestMapping(path = "/changePassword")
    public String changePassword()
    {
        return null;
    }

    public boolean checkUser()
    {
        String userEmail = "admin@localhost.com";
        List<User> list = userService.getAllUser();
        for (User us: list) {
            if (us.getEmail().equals(userEmail))
            {
                return true;
            }
        }
        return false;
    }

    public void createUserAdmin()
    {
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("USER");
         Role roleComplete =   roleService.insertRole(role);
        Role role2 = new Role();
        role2.setRoleId(2);
        role2.setRoleName("ADMIN");
        Role role2Complete = roleService.insertRole(role2);

        User userAdmin = new User();
        userAdmin.setUsername("adminadmin");
        userAdmin.setEmail("admin@localhost.com");
        userAdmin.setPassword("admin");
        User userAdminComplete = userService.saveUser(userAdmin);

        UserRole ur = new UserRole();
        ur.setRole(roleComplete);
        ur.setUser(userAdminComplete);
        userRoleService.saveRole(ur);
        UserRole ur2 = new  UserRole();
        ur2.setRole(role2Complete);
        ur2.setUser(userAdminComplete);
        userRoleService.saveRole(ur2);
    }

}
