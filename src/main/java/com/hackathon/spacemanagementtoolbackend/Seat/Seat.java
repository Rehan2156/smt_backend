package com.hackathon.spacemanagementtoolbackend.Seat;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Integer id;

    private int teamId;

    private int floorId;

    private int zoneId;

    private int seatNumber;

    private boolean booked;

    private Date startDate;
    private Date endDate;

    public Seat(int teamId, int floorId, int zoneId, int seatNumber, boolean booked, Date startDate, Date endDate) {
        this.id = null;
        this.teamId = teamId;
        this.floorId = floorId;
        this.zoneId = zoneId;
        this.seatNumber = seatNumber;
        this.booked = booked;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Seat(){

    }
}
