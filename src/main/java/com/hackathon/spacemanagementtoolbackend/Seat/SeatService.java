package com.hackathon.spacemanagementtoolbackend.Seat;

import com.hackathon.spacemanagementtoolbackend.floor.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatRepository seatRepository;

    public List<Seat> getAllSeats(int teamId, int floorId, int zoneId){
        return seatRepository.findAllByTeamIdAndFloorIdAndZoneId(teamId, floorId, zoneId);
    }

    public Seat findSeat(int seatId){
        return seatRepository.findSeatById(seatId);
    }

    public List<Seat> saveAll(List<Seat> seatsList)
    {
        return seatRepository.saveAll(seatsList);
    }
}
