package com.hackathon.spacemanagementtoolbackend.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/findall")
    public ArrayList<Employee> getAllEmployee() {
        return employeeService.findAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Employee employee, HttpServletRequest request){

        if(employeeService.usernameNotFound(employee.getUserName(),employee.getPassWord()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid credentials");

        return ResponseEntity.ok(employeeService.getEmployeeByUsername(employee.getUserName()));
    }

}
