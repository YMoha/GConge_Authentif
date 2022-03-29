package com.example.authetificationconge.services;

import com.example.authetificationconge.entities.Employer;




public interface EmployerService {

    public Employer saveEmployer(Employer employer);
    public Employer loadEmployerbyUsername(String username);
    public Employer deleteEmployer(long id);
}
