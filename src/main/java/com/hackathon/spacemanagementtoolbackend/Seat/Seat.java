package com.hackathon.spacemanagementtoolbackend.Seat;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@Entity
@Data
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int teamId;

    private int floorId;

    private int zoneId;

    private int seatNumber;

    private boolean booked;

    public Seat(int teamId, int floorId, int zoneId, int seatNumber, boolean booked) {
        this.teamId = teamId;
        this.floorId = floorId;
        this.zoneId = zoneId;
        this.seatNumber = seatNumber;
        this.booked = booked;
    }

    public Seat(){

    }
}
