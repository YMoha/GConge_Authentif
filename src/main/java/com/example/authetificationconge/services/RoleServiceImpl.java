package com.example.authetificationconge.services;


import com.example.authetificationconge.entities.Roles;
import com.example.authetificationconge.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Roles saveR(Roles roles) {
        return roleRepository.save(roles);
    }


}
