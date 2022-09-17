package com.hackathon.spacemanagementtoolbackend.teamfloorzone;

import com.hackathon.spacemanagementtoolbackend.floor.Floor;
import com.hackathon.spacemanagementtoolbackend.floor.FloorService;
import com.hackathon.spacemanagementtoolbackend.zone.Zone;
import com.hackathon.spacemanagementtoolbackend.zone.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamFloorZoneController {
    @Autowired
    TeamFloorZoneService teamFloorZoneService;

    @Autowired
    FloorService floorService;

    @Autowired
    ZoneService zoneService;

    @GetMapping("/getFloors")
    public List<Floor> getFloorByTeamId(@RequestParam("teamId") int teamId)
    {
        List<TeamFloorZone> teamFloorZoneList = teamFloorZoneService.getAllByTeamId(teamId);
        List<Floor> floorList = new ArrayList<>();

        for(TeamFloorZone teamFloorZone: teamFloorZoneList)
        {
            floorList.add(floorService.getFloorData(teamFloorZone.getFloorId()));
        }

        return floorList;
    }

    @GetMapping("/getZones")
    public List<Zone> getZoneByTeamIdAndFloorId(@RequestParam("teamId") int teamId, @RequestParam("floorId") int floorId){

        return zoneService.getZoneData(teamId, floorId);

    }
}
