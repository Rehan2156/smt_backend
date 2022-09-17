package com.hackathon.spacemanagementtoolbackend.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public ArrayList<Employee> findAllUsers() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public void addDummyUsers(){
        Employee user = new Employee("abc","abc",123,10);

        employeeRepository.save(user);
    }

    public boolean usernameNotFound(String username,String password) {
        return !employeeRepository.existsByUsernameAndPassword(username,password);
    }

    public Employee getEmployeeByUsername(String username){
        return employeeRepository.findEmployeeByUsername(username);
    }
}
