package com.hackathon.spacemanagementtoolbackend.employee;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String userName;
    private String passWord;

    private int teamId;

    private int totalSeats;

    public Employee(String userName, String passWord, int teamId, int totalSeats) {
        this.userName = userName;
        this.passWord = passWord;
        this.teamId = teamId;
        this.totalSeats = totalSeats;
    }

}

