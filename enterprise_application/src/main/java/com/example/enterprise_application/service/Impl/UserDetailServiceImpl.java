package com.example.enterprise_application.service.Impl;


import com.example.enterprise_application.jpa.User;
import com.example.enterprise_application.jpa.UserRole;
import com.example.enterprise_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user== null)throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole role:user.getUserRoles())
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                grantedAuthorities);
    }
}
