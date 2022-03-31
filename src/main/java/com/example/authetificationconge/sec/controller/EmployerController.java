package com.example.authetificationconge.sec.controller;


import com.example.authetificationconge.sec.entities.Employer;
import com.example.authetificationconge.sec.services.EmployerService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(path = "/Employers")
    public List<Employer> employerList(){

        return employerService.listEmployer();
    }

    @PostMapping(path = "/Employers")
    public  Employer saveEmployer(@RequestBody Employer employer){
        return employerService.saveEmployer(employer);
    }



    @Data
    class FormUser {

        private String username;
        private String confirmedPassword;
        private String roleName;

    }
}

