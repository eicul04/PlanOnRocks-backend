package com.planOnRocks.domain.climbingRock;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "climbing_rock")
@Entity
public class ClimbingRock {
    @EmbeddedId
    @Column(name = "location", nullable = false)
    private Location location;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "bolting")
    private Bolting bolting;

    @Embeddable
    public static class Location implements Serializable {
        private final double latitude;
        private final double longitude;

        public Location(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Location() {
            this.latitude = 0.0;
            this.longitude = 0.0;
        }
    }

    //TODO put something in void constructor
    public ClimbingRock() {
    }

    public ClimbingRock(Location location, String name, Difficulty difficulty, Bolting bolting) {
        this.location = location;
        this.name = name;
        this.difficulty = difficulty;
        this.bolting = bolting;
    }
}