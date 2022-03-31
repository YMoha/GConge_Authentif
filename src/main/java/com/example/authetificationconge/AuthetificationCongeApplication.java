package com.example.authetificationconge;

import com.example.authetificationconge.sec.entities.Employer;
import com.example.authetificationconge.sec.entities.Roles;
import com.example.authetificationconge.sec.services.EmployerService;
import com.example.authetificationconge.sec.services.RoleService;
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

            Roles r = new Roles();
            r.setRoleName("Admin");
            roleService.saveR(r);
            Roles r1 = new Roles();
            r1.setRoleName("Directeur BU");
            roleService.saveR(r1);
            Roles r2 = new Roles();
            r2.setRoleName("Responsable Pool");
            roleService.saveR(r2);
            Roles r3 = new Roles();
            r3.setRoleName("Chef Projet");
            roleService.saveR(r3);
            Roles r4 = new Roles();
            r4.setRoleName("Employer");
            roleService.saveR(r4);

//            roleService.saveR(new Roles(null,"Directeur BU"));
//            roleService.saveR(new Roles(null,"Responsable Pool"));
//            roleService.saveR(new Roles(null,"Chef Projet"));
//            roleService.saveR(new Roles(null,"Employer"));
            //******Ajouté des Employers*****/
            Employer em1 = new Employer();
            em1.setUsername("Youssef");
            em1.setPassword("1234");
            em1.setRoles(new ArrayList<>());
            employerService.saveEmployer(em1);
            Employer em2 = new Employer();
            em2.setUsername("Mouad");
            em2.setPassword("1234");
            em2.setRoles(new ArrayList<>());
            employerService.saveEmployer(em2);
            Employer em3 = new Employer();
            em3.setUsername("Lamaie");
            em3.setPassword("1234");
            em3.setRoles(new ArrayList<>());
            employerService.saveEmployer(em3);
            Employer em4 = new Employer();
            em4.setUsername("Mouna");
            em4.setPassword("1234");
            em4.setRoles(new ArrayList<>());
            employerService.saveEmployer(em4);
           // employerService.saveEmployer(new Employer(null,"Admin","1234",new ArrayList<>()));
           // employerService.saveEmployer(new Employer(null,"Yassmine","1234",new ArrayList<>()));
           // employerService.saveEmployer(new Employer(null,"Mahmoud","1234",new ArrayList<>()));
           // employerService.saveEmployer(new Employer(null,"Amal","1234",new ArrayList<>()));


        };
    };

}
