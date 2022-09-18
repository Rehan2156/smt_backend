package com.hackathon.spacemanagementtoolbackend.dto;


import lombok.Data;

@Data
public class TeamDto {

    private int id;
    private String teamName;
    private String oeCode;
    private int managerId;
    private String managerName;
    private String teamDescription;

    public TeamDto(int id, String teamName, String oeCode, int managerId, String managerName, String teamDescription) {
        this.id = id;
        this.teamName = teamName;
        this.oeCode = oeCode;
        this.managerId = managerId;
        this.managerName = managerName;
        this.teamDescription = teamDescription;
    }
}
