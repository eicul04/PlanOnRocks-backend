package com.planOnRocks.domain.climbingRock;

import com.planOnRocks.domain.destination.Location;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "climbing_rock")
@Entity
public class ClimbingRock {

    @EmbeddedId
    @Column(name = "location", nullable = false, unique = true)
    private Location climbingRockLocation;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "bolting")
    private Bolting bolting;

    //TODO put something in void constructor
    public ClimbingRock() {
    }

    public ClimbingRock(Location climbingRockLocation, String name, Difficulty difficulty, Bolting bolting) {
        this.climbingRockLocation = climbingRockLocation;
        this.name = name;
        this.difficulty = difficulty;
        this.bolting = bolting;
    }

    public Location getClimbingRockLocation() {
        return climbingRockLocation;
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