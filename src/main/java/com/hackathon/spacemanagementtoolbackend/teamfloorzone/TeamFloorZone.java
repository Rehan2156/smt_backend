package com.hackathon.spacemanagementtoolbackend.teamfloorzone;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class TeamFloorZone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String teamId;
    private String floorId;


}

@Repository
interface TeamRepository extends JpaRepository<com.hackathon.spacemanagementtoolbackend.team.Team, Integer> {

    com.hackathon.spacemanagementtoolbackend.team.Team findById(int id);

}

