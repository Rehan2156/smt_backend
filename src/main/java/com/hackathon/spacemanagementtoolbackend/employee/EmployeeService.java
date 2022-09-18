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

    public boolean usernameNotFound(String username, String password) {
        return !employeeRepository.existsByUserNameAndPassWord(username, password);
    }

    public Employee getEmployeeByUsername(String username) {
        return employeeRepository.findEmployeeByUserName(username);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    public Employee reduceSeatCount(int employeeId, int seatCount) {
        Employee employee = employeeRepository.findEmployeeById(employeeId);
        employee.setTotalSeats(employee.getTotalSeats() - seatCount);
        return employeeRepository.save(employee);
    }

    public Employee assignSeatCount(int employeeId, int seatCount) {
        Employee employee = employeeRepository.findEmployeeById(employeeId);
        employee.setTotalSeats(employee.getTotalSeats() + seatCount);
        return employeeRepository.save(employee);
    }

}
