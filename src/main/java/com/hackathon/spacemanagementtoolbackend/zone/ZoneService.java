package com.hackathon.spacemanagementtoolbackend.zone;

import com.hackathon.spacemanagementtoolbackend.floor.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    public List<Zone> getZoneData(int teamId, int floorId){
        return zoneRepository.findAllByTeamIdAndFloorId(teamId, floorId);
    }

    public Zone getZoneById(Integer zoneId){
        Optional<Zone> zone = zoneRepository.findById(zoneId);
        if(zone.isPresent()){
            return zone.get();
        }
        return new Zone();
    }

    public Zone saveZone(Zone zone){
        return zoneRepository.save(zone);
    }
}
