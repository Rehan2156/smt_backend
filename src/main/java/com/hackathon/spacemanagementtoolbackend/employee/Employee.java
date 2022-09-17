package com.hackathon.spacemanagementtoolbackend.employee;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;

    private int teamId;

    private int totalSeats;

    public Employee(String username, String password, int teamId, int totalSeats) {
        this.username = username;
        this.password = password;
        this.teamId = teamId;
        this.totalSeats = totalSeats;
    }

    public Employee() {

    }
}

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long>{
    ArrayList<Employee> findAll();
    Employee findEmployeeByUsername(String username);
    boolean existsByUsernameAndPassword(String username,String password);
}
