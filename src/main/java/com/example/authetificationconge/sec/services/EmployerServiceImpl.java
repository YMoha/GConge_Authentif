package com.example.authetificationconge.sec.services;

import com.example.authetificationconge.sec.entities.Employer;
import com.example.authetificationconge.sec.entities.Roles;
import com.example.authetificationconge.sec.repository.EmployerRepository;

import com.example.authetificationconge.sec.repository.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

    private EmployerRepository employerRepository;
    private RoleRepository roleRepository;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployerServiceImpl(EmployerRepository employerRepository, RoleRepository roleRepository) {
        this.employerRepository = employerRepository;
        this.roleRepository = roleRepository;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Employer saveEmployer(Employer employer) {
//        String pw= employer.getPassword() ;
//        employer.setPassword(bCryptPasswordEncoder.encode(pw));
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
    public Employer deleteEmployer(long id) {
        return null;
    }
}
