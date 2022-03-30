package com.example.authetificationconge.services;

import com.example.authetificationconge.entities.Employer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployerService {

    public Employer saveEmployer(Employer employer);
    public Employer loadEmployerbyUsername(String username);
    public List<Employer> listEmployer();
    void addRoletoEmpl(String userName ,String roleName);
    public Employer deleteEmployer(long id);
}
