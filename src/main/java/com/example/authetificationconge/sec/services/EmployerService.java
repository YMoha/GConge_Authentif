package com.example.authetificationconge.sec.services;

import com.example.authetificationconge.sec.entities.Employer;

import java.util.List;


public interface EmployerService {

    public Employer saveEmployer(Employer employer);
    public Employer loadEmployerbyUsername(String username);
    public List<Employer> listEmployer();
    public Employer deleteEmployer(long id);
}
