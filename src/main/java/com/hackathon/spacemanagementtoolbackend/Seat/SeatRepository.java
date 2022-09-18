package com.hackathon.spacemanagementtoolbackend.floor;

import com.hackathon.spacemanagementtoolbackend.Seat.Seat;
import com.hackathon.spacemanagementtoolbackend.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findAllByTeamIdAndFloorIdAndZoneId(int teamId, int floorId, int zoneId);

    Seat findSeatById(int seatId);

}
