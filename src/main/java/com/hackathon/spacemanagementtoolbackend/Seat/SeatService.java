package com.hackathon.spacemanagementtoolbackend.Seat;

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

    public Seat save(Seat seat){
        return seatRepository.save(seat);
    }

    public List<Seat> findSeatsByTeamId(Integer teamId){
        return seatRepository.findSeatByTeamId(teamId);
    }

    public List<Seat> findSeatsByTeamIdAndFloorId(Integer teamId, Integer floorId){

        return seatRepository.findAllByTeamIdAndFloorId(teamId, floorId);

    }

    public List<Seat> updateSeatsBySeatId(List<Seat>  seats){

        return seatRepository.saveAll(seats);

    }
}
