package com.example.authetificationconge.sec.services;

import com.example.authetificationconge.sec.entities.Employer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailserviceImpl implements UserDetailsService{

    private EmployerService employerService;
    private RoleService roleService;

    public UserDetailserviceImpl(EmployerService employerService, RoleService roleService) {
        this.employerService = employerService;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        Employer employer = employerService.loadEmployerbyUsername(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        employer.getRoles(). forEach(r ->
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()))
        );
        System.out.println(authorities);
        return new User(employer.getUsername(),employer.getPassword(),authorities);
    }


}