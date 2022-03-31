package com.example.authetificationconge.sec.services;


import com.example.authetificationconge.sec.entities.Roles;
import com.example.authetificationconge.sec.repository.RoleRepository;
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
