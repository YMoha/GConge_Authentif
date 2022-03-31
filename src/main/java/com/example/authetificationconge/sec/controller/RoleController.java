package com.example.authetificationconge.sec.controller;



import com.example.authetificationconge.sec.entities.Roles;
import com.example.authetificationconge.sec.services.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(path = "/Roles/saveR")
    public Roles saveR(@RequestBody Roles roles) {
        return roleService.saveR(roles);
    }
}
