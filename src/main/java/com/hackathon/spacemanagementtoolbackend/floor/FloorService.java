package com.hackathon.spacemanagementtoolbackend.floor;

import com.hackathon.spacemanagementtoolbackend.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {
    @Autowired
    FloorRepository floorRepository;

    public Floor getFloorData(int id){

        return floorRepository.findById(id);
    }
}
