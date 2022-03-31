package com.example.authetificationconge.sec.repository;


import com.example.authetificationconge.sec.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

    public Employer findByUsername(String username);
}
