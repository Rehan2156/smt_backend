package com.hackathon.spacemanagementtoolbackend.zone;

import com.hackathon.spacemanagementtoolbackend.floor.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    public List<Zone> getZoneData(int teamId, int floorId){
        return zoneRepository.findAllByTeamIdAndFloorId(teamId, floorId);
    }
}
