package com.example.authetificationconge;

import com.example.authetificationconge.entities.Employer;
import com.example.authetificationconge.entities.Roles;
import com.example.authetificationconge.services.EmployerService;
import com.example.authetificationconge.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;

@SpringBootApplication
public class AuthetificationCongeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthetificationCongeApplication.class, args);
    }
    @Bean
        BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner start (RoleService roleService, EmployerService employerService) {
        return args -> {
            //******Ajouté des roles*****/
            roleService.saveR(new Roles(null,"Admin"));
            roleService.saveR(new Roles(null,"Directeur BU"));
            roleService.saveR(new Roles(null,"Responsable Pool"));
            roleService.saveR(new Roles(null,"Chef Projet"));
            roleService.saveR(new Roles(null,"Employer"));
            //******Ajouté des Employers*****/
            employerService.saveEmployer(new Employer(null,"Youssef","1234",new ArrayList<>()));
            employerService.saveEmployer(new Employer(null,"Admin","1234",new ArrayList<>()));
            employerService.saveEmployer(new Employer(null,"Yassmine","1234",new ArrayList<>()));
            employerService.saveEmployer(new Employer(null,"Mahmoud","1234",new ArrayList<>()));
            employerService.saveEmployer(new Employer(null,"Amal","1234",new ArrayList<>()));


        };
    };

}
