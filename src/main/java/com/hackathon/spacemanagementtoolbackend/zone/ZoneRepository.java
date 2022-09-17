package com.hackathon.spacemanagementtoolbackend.floor;

import com.hackathon.spacemanagementtoolbackend.team.Team;
import com.hackathon.spacemanagementtoolbackend.zone.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {

    Zone findAllByFloorId(int id);

}
