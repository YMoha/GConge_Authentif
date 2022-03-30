package com.example.authetificationconge.services;

import com.example.authetificationconge.entities.Employer;
import com.example.authetificationconge.entities.Roles;
import com.example.authetificationconge.repository.EmployerRepository;

import com.example.authetificationconge.repository.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

    private EmployerRepository employerRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployerServiceImpl(EmployerRepository employerRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employerRepository = employerRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Employer saveEmployer(Employer employer) {
        String pw= employer.getPassword() ;
        employer.setPassword(bCryptPasswordEncoder.encode(pw));
        return employerRepository.save(employer);

    }

    @Override
    public Employer loadEmployerbyUsername(String username) {
        return employerRepository.findByUsername(username);
    }

    @Override
    public List<Employer> listEmployer() {
        return employerRepository.findAll();
    }

    @Override
    public void addRoletoEmpl(String userName, String roleName) {
        Employer employer = employerRepository.findByUsername(userName);
        Roles roles = roleRepository.findByRoleName(roleName);
        employer.getRoles().add(roles);
    }

    @Override
    public Employer deleteEmployer(long id) {
        return null;
    }
}
