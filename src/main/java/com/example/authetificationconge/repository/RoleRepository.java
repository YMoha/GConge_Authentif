package com.example.authetificationconge.repository;

import com.example.authetificationconge.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

    public Roles findByRoleName(String roleName);
}
