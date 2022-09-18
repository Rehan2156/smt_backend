package com.hackathon.spacemanagementtoolbackend.teams_under_employee;

import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "teamsunderemployee")
public class TeamsUnderEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int teamId;

    private int employeeId;

    public TeamsUnderEmployee() {

    }
}



