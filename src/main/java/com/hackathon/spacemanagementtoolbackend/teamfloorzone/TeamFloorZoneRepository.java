package com.hackathon.spacemanagementtoolbackend.teamfloorzone;

import com.hackathon.spacemanagementtoolbackend.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamFloorZoneRepository extends JpaRepository<TeamFloorZone, Integer> {
    List<TeamFloorZone> findAllByTeamId(int teamId);
}
