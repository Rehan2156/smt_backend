package com.hackathon.spacemanagementtoolbackend.teams_under_employee;

import com.hackathon.spacemanagementtoolbackend.dto.TeamDto;
import com.hackathon.spacemanagementtoolbackend.employee.Employee;
import com.hackathon.spacemanagementtoolbackend.employee.EmployeeService;
import com.hackathon.spacemanagementtoolbackend.team.Team;
import com.hackathon.spacemanagementtoolbackend.team.TeamService;
import com.hackathon.spacemanagementtoolbackend.teamManager.TeamManager;
import com.hackathon.spacemanagementtoolbackend.teamManager.TeamManagerService;
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

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TeamManagerService teamManagerService;

    @GetMapping("/getTeams")
    public List<TeamDto> getAllTeamsUnderEmpID(@RequestParam("userId") int id)
    {
        List<TeamsUnderEmployee> teamsUnderEmployeeList = teamsUnderEmployeeService.getAllTeamUnderEmpID(id);
        List<TeamDto> teamDtoList = new ArrayList<>();
        for(TeamsUnderEmployee teamUnderEmployee: teamsUnderEmployeeList)
        {

            Team team = teamService.getTeamData(teamUnderEmployee.getTeamId());
            TeamManager teamManager = teamManagerService.getTeamData(team.getId());
            Employee manager = employeeService.getEmployeeById(teamManager.getTeamLeadId());

            TeamDto teamDto = new TeamDto(team.getId(), team.getTeamName(), team.getOeCode(), manager.getId(),
                    manager.getUserName(), team.getTeamDescription());
            teamDtoList.add(teamDto);
        }
        return teamDtoList;
    }

}
