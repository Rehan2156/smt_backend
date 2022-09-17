package com.hackathon.spacemanagementtoolbackend.floor;

import com.hackathon.spacemanagementtoolbackend.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FloorRepository extends JpaRepository<Floor, Integer> {

    Floor findById(int id);

}
