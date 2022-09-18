package com.hackathon.spacemanagementtoolbackend.Seat;

import com.hackathon.spacemanagementtoolbackend.employee.Employee;
import com.hackathon.spacemanagementtoolbackend.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping("/seats")
    public List<Seat> getSeats(@RequestParam("teamId") int teamId, @RequestParam("floorId") int floorId, @RequestParam("zoneId") int zoneId){
        return seatService.getAllSeats(teamId, floorId, zoneId);
    }

}
