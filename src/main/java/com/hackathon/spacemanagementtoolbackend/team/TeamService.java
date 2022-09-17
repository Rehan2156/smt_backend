package com.hackathon.spacemanagementtoolbackend.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Team getTeamData(int teamId){

        return teamRepository.findById(teamId);
    }




}
