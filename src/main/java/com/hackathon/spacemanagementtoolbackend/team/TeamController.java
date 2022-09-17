package com.hackathon.spacemanagementtoolbackend.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

//    @GetMapping("/getTeams/{id}")
//    public List<Team> getTeamsUnderEmployee()
//    {
//
//    }
}
