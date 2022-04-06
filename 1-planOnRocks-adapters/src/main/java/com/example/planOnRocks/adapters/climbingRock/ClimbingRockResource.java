package com.example.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.Bolting;
import com.planOnRocks.domain.climbingRock.Difficulty;

public class ClimbingRockResource {

    private String location;
    private String name;
    private Difficulty difficulty;
    private Bolting bolting;

    public ClimbingRockResource(String location, String name, Difficulty difficulty, Bolting bolting) {
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
