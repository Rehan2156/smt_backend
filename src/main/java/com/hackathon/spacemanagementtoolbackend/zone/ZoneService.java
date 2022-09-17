package com.hackathon.spacemanagementtoolbackend.zone;

import com.hackathon.spacemanagementtoolbackend.floor.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    public Zone getZoneData(int floorId){
        return zoneRepository.findAllByFloorId(floorId);
    }
}
