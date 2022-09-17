package com.hackathon.spacemanagementtoolbackend.teams_under_employee;

import com.hackathon.spacemanagementtoolbackend.team.Team;
import com.hackathon.spacemanagementtoolbackend.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamsUnderEmployeeController {
    @Autowired
    TeamsUnderEmployeeService teamsUnderEmployeeService;

    @Autowired
    TeamService teamService;

    @GetMapping("/getTeams")
    public List<Team> getAllTeamsUnderEmpID(@RequestParam("userId") int id)
    {
        List<TeamsUnderEmployee> teamsUnderEmployeeList = teamsUnderEmployeeService.getAllTeamUnderEmpID(id);
        List<Team> teamList = new ArrayList<>();
        for(TeamsUnderEmployee teamUnderEmployee: teamsUnderEmployeeList)
        {
            teamList.add(teamService.getTeamData(teamUnderEmployee.getTeamId()));
        }
        return teamList;
    }

}
