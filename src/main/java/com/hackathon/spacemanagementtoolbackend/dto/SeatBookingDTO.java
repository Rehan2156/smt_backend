package com.hackathon.spacemanagementtoolbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SeatBookingDTO {
    private int employeeId;

    private int teamId;

    private int floorId;

    private int zoneId;

    private List<Integer> seatIds;
}
