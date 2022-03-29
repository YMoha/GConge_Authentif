package com.example.authetificationconge;

import com.example.authetificationconge.entities.Employer;
import com.example.authetificationconge.services.EmployerService;
import com.example.authetificationconge.services.RoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsServiceImpl implements UserDetailsService {

    private EmployerService employerService;
    private RoleService roleService;

    public UserDetailsServiceImpl(EmployerService employerService, RoleService roleService) {
        this.employerService = employerService;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employer employer =employerService.loadEmployerbyUsername(username);
        Object Employer = username;
        if(Employer==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        employer.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new User(employer.getUsername(), employer.getPassword(),authorities);
    }
}
