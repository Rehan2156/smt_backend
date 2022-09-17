package com.hackathon.spacemanagementtoolbackend.teams_under_employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
interface TeamsUnderEmployeeRepository extends JpaRepository<TeamsUnderEmployee, Long> {
    ArrayList<TeamsUnderEmployee> findAll();

    List<TeamsUnderEmployee> findAllByEmployeeId(int employeeId );

}
