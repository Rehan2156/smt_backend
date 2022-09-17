package com.hackathon.spacemanagementtoolbackend.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeamRepository extends JpaRepository<Team, Integer> {

    Team findById(int id);

}
