package com.hackathon.spacemanagementtoolbackend.teamManager;

import com.hackathon.spacemanagementtoolbackend.teamfloorzone.TeamFloorZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamManager, Integer> {
    TeamManager findTeamManagerByTeamId(int teamId);
}
