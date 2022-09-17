package com.hackathon.spacemanagementtoolbackend.team;
import com.hackathon.spacemanagementtoolbackend.employee.Employee;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
    private String team;
    private String oeCode;


}

