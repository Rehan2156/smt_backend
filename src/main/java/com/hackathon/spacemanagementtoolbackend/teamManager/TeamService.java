package com.hackathon.spacemanagementtoolbackend.teamManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public TeamManager getTeamData(int teamId)
    {
        return teamRepository.findTeamManagerByTeamId(teamId);
    }
}
