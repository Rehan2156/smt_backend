package com.hackathon.spacemanagementtoolbackend.Seat;

import com.hackathon.spacemanagementtoolbackend.dto.SeatBookingDTO;
import com.hackathon.spacemanagementtoolbackend.employee.EmployeeService;
import com.hackathon.spacemanagementtoolbackend.floor.Floor;
import com.hackathon.spacemanagementtoolbackend.floor.FloorService;
import com.hackathon.spacemanagementtoolbackend.team.TeamService;
import com.hackathon.spacemanagementtoolbackend.teamManager.TeamManager;
import com.hackathon.spacemanagementtoolbackend.teamManager.TeamManagerService;
import com.hackathon.spacemanagementtoolbackend.teamfloorzone.TeamFloorZone;
import com.hackathon.spacemanagementtoolbackend.teamfloorzone.TeamFloorZoneService;
import com.hackathon.spacemanagementtoolbackend.zone.Zone;
import com.hackathon.spacemanagementtoolbackend.zone.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SeatController {

    @Autowired
    SeatService seatService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TeamService teamService;

    @Autowired
    TeamManagerService teamManagerService;

    @Autowired
    TeamFloorZoneService teamFloorZoneService;

    @Autowired
    ZoneService zoneService;

    @Autowired
    FloorService floorService;

    @GetMapping("/seats")
    public List<Seat> getSeats(@RequestParam("teamId") int teamId, @RequestParam("floorId") int floorId, @RequestParam("zoneId") int zoneId) {
        return seatService.getAllSeats(teamId, floorId, zoneId);
    }

    @PutMapping("/bookSeats")
    public ResponseEntity<Object> bookSeats(@RequestBody SeatBookingDTO seatBookingDTO) {
        try {
            List<Integer> seatList = seatBookingDTO.getSeatIds();
            List<Seat> updatedSeatList = new ArrayList<>();
            for (Integer seatId : seatList) {
                Seat currSeat = seatService.findSeat(seatId);
                currSeat.setBooked(true);
                updatedSeatList.add(currSeat);
            }

            seatService.saveAll(updatedSeatList);
            employeeService.updateSeatCount(seatBookingDTO.getEmployeeId(), seatList.size(), false);
            TeamManager team1 = teamManagerService.getTeamData(seatBookingDTO.getTeamId());
            employeeService.updateSeatCount(team1.getTeamLeadId(), seatList.size(), true);
            for (Integer seatId : seatList) {

                Seat seatFromDb = seatService.findSeat(seatId);

                Seat seat = new Seat(seatBookingDTO.getTeamId(), seatBookingDTO.getFloorId(), seatBookingDTO.getZoneId(), seatFromDb.getSeatNumber(), false, seatFromDb.getStartDate(), seatFromDb.getEndDate());

                seatService.save(seat);
            }
            TeamFloorZone teamFloorZone = new TeamFloorZone(seatBookingDTO.getTeamId(), seatBookingDTO.getFloorId(), seatBookingDTO.getZoneId());
            Zone zoneFromDb = zoneService.getZoneById(seatBookingDTO.getZoneId());
            Zone zone = new Zone(seatBookingDTO.getFloorId(), seatBookingDTO.getTeamId(), zoneFromDb.getZoneName());
            teamFloorZoneService.save(teamFloorZone);
            zoneService.saveZone(zone);
            return ResponseEntity.ok("Seats booked successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Seats not booked");
        }

    }

    @GetMapping("/getFloors")
    public List<Floor> getFloorByTeamId(@RequestParam("teamId") int teamId) {

        List<Seat> seats = seatService.findSeatsByTeamId(teamId);
        List<Floor> floors = new ArrayList<>();
        for (Seat seat : seats) {

            Floor floor = floorService.getFloorData(seat.getFloorId());
            floors.add(floor);
        }
        return floors.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    @GetMapping("/getZones")
    public List<Zone> getZoneByTeamIdAndFloorId(@RequestParam("teamId") int teamId, @RequestParam("floorId") int floorId) {

        List<Seat> seats = seatService.findSeatsByTeamIdAndFloorId(teamId, floorId);

        List<Zone> zones = new ArrayList<>();

        for (Seat seat : seats) {
            Zone zone = zoneService.getZoneById(seat.getZoneId());
            zones.add(zone);

        }
        return zones.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    @PutMapping("/unallocateSeats")
    public ResponseEntity<Object> Seats(@RequestBody SeatBookingDTO seatBookingDTO) {
        try {
            List<Integer> seatList = seatBookingDTO.getSeatIds();
            List<Seat> updatedSeatList = new ArrayList<>();
            for (Integer seatId : seatList) {
                Seat currSeat = seatService.findSeat(seatId);
                currSeat.setBooked(false);
                updatedSeatList.add(currSeat);
                List<Seat> seats = seatService.findSeatsByTeamIdFloorIdZoneIdAndSeatNumber(seatBookingDTO.getTeamId()
                        , seatBookingDTO.getFloorId(), seatBookingDTO.getTeamId(), currSeat.getSeatNumber());

                for (Seat seat : seats) {
                    seatService.save(seat);
                }
            }

            seatService.saveAll(updatedSeatList);
            employeeService.updateSeatCount(seatBookingDTO.getEmployeeId(), seatList.size(), true);
            TeamManager team1 = teamManagerService.getTeamData(seatBookingDTO.getTeamId());
            employeeService.updateSeatCount(team1.getTeamLeadId(), seatList.size(), false);
            return ResponseEntity.ok("Seats unallocated successfully");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Seats unallocation failed");

        }

    }
}
