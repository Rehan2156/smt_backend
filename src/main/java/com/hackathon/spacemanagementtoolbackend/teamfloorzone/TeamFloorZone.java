package com.hackathon.spacemanagementtoolbackend.teamfloorzone;

import com.hackathon.spacemanagementtoolbackend.team.Team;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Data
@Table(name="teamfloorzone")
public class TeamFloorZone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int teamId;
    private int floorId;
    private int zoneId;
    private int seatFrom;
    private int seatTo;
}
