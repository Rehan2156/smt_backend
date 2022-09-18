package com.hackathon.spacemanagementtoolbackend.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    ArrayList<Employee> findAll();
    Employee findEmployeeByUserName(String username);

    Employee findEmployeeById(int id);
    boolean existsByUserNameAndPassWord(String username,String password);
}
