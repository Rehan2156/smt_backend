package com.hackathon.spacemanagementtoolbackend.teams_under_employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsUnderEmployeeService {
    @Autowired
    TeamsUnderEmployeeRepository teamsUnderEmployeeRepository;

    public List<TeamsUnderEmployee> getAllTeamUnderEmpID(int empid)
    {
        return teamsUnderEmployeeRepository.findAllByEmployeeId(empid);
    }
}
