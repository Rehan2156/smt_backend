package com.hackathon.spacemanagementtoolbackend.Seat;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int teamId;

    private int floorId;

    private int zoneId;

    private boolean booked;
}
