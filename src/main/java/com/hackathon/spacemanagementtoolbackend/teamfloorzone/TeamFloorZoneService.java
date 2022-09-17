package com.hackathon.spacemanagementtoolbackend.teamfloorzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamFloorZoneService {
    @Autowired
    TeamFloorZoneRepository teamFloorZoneRepository;

    public List<TeamFloorZone> getAllByTeamId(int teamId){
        return teamFloorZoneRepository.findAllByTeamId(teamId);
    }
}
