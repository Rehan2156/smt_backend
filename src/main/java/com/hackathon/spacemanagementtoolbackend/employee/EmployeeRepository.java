package com.hackathon.spacemanagementtoolbackend.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    ArrayList<Employee> findAll();
    Employee findEmployeeByUsername(String username);
    boolean existsByUsernameAndPassword(String username,String password);
}
