package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.enums.Bolting;
import com.planOnRocks.domain.climbingRock.enums.Difficulty;

public class ClimbingRockDTO {

    private final String location;
    private final String name;
    private final Difficulty difficulty;
    private final Bolting bolting;

    public ClimbingRockDTO(String location, String name, Difficulty difficulty, Bolting bolting) {
        this.location = location;
        this.name = name;
        this.difficulty = difficulty;
        this.bolting = bolting;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Bolting getBolting() {
        return bolting;
    }

}
