package com.planOnRocks.domain.climbingRock;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "climbing_rock")
@Entity
public class ClimbingRock {
    @EmbeddedId
    @Column(name = "location", nullable = false)
    private Location location;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "bolting")
    private Bolting bolting;

    @Embeddable
    public class Location implements Serializable {
        private final double latitude;
        private final double longitude;

        public Location(long latitude, long longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Location() {
            this.latitude = 0.0;
            this.longitude = 0.0;
        }
    }

    public ClimbingRock() {
    }

    public ClimbingRock(Location location, Difficulty difficulty, Bolting bolting) {
        this.location = location;
        this.difficulty = difficulty;
        this.bolting = bolting;
    }
}