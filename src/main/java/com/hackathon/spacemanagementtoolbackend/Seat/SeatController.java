package com.hackathon.spacemanagementtoolbackend.Seat;

import com.hackathon.spacemanagementtoolbackend.dto.SeatBookingDTO;
import com.hackathon.spacemanagementtoolbackend.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatController {

    @Autowired
    SeatService seatService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/seats")
    public List<Seat> getSeats(@RequestParam("teamId") int teamId, @RequestParam("floorId") int floorId, @RequestParam("zoneId") int zoneId){
        return seatService.getAllSeats(teamId, floorId, zoneId);
    }

    @PutMapping("/bookSeats")
    public ResponseEntity<Object> bookSeats(@RequestBody SeatBookingDTO seatBookingDTO)
    {
        try {
            List<Integer> seatList = seatBookingDTO.getSeatIds();
            List<Seat> updatedSeatList = new ArrayList<>();
            for (Integer seatId : seatList) {
                Seat currSeat = seatService.findSeat(seatId);
                currSeat.setBooked(true);
                updatedSeatList.add(currSeat);
            }

            seatService.saveAll(updatedSeatList);
            employeeService.reduceSeatCount(seatBookingDTO.getEmployeeId(),seatList.size());
            return ResponseEntity.ok("Seats booked successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Seats not booked");
        }

    }
}
