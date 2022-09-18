package com.hackathon.spacemanagementtoolbackend.teamManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamManagerService {
    @Autowired
    TeamManagerRepository teamManagerRepository;

    public TeamManager getTeamData(int teamId)
    {
        return teamManagerRepository.findTeamManagerByTeamId(teamId);
    }
}
