package com.example.authetificationconge.controller;

import com.example.authetificationconge.entities.Employer;
import com.example.authetificationconge.services.EmployerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployerController {

    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping(path = "/employers/save")
    public  Employer saveEmployer(@RequestBody Employer employer){
        return employerService.saveEmployer(employer);
    }
}
