package com.example.authetificationconge.services;

import com.example.authetificationconge.entities.Employer;
import com.example.authetificationconge.repository.EmployerRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

    private EmployerRepository employerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployerServiceImpl(EmployerRepository employerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employerRepository = employerRepository;
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
    public Employer deleteEmployer(long id) {
        return null;
    }
}
