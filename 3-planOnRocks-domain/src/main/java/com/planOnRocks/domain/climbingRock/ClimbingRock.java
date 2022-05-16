package com.planOnRocks.domain.climbingRock;

import com.planOnRocks.domain.trip.Trip;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "climbing_rock")
@Entity
public class ClimbingRock {

    @Id
    @Convert(
            converter = LocationConverter.class
    )
    @Column(name = "location", nullable = false, unique = true)
    private Location climbingRockLocation;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "bolting")
    private Bolting bolting;

    @ManyToMany(mappedBy = "climbingRocks", cascade = {CascadeType.PERSIST})
    private List<Trip> trips = new ArrayList<>();

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