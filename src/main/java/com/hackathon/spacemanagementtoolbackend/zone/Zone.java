package com.hackathon.spacemanagementtoolbackend.zone;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Zone {
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int floorId;

    private int teamId;

    private String zoneName;

    public Zone(int floorId, int teamId, String zoneName) {
        this.id = null;
        this.floorId = floorId;
        this.teamId = teamId;
        this.zoneName = zoneName;
    }

    public Zone() {
    }
}
