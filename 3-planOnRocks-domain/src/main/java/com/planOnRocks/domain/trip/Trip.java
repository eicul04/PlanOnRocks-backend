package com.planOnRocks.domain.trip;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Difficulty;
import com.planOnRocks.domain.climbingRock.TripCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "trip")
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", nullable = false)
    private Long id;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "participantExperience")
    private ParticipantExperience participantExperience;

    @Column(name = "tripCategory")
    private TripCategory tripCategory;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "trip_climbingRock",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "climbing_rock_id"))
    private List<ClimbingRock> climbingRocks = new ArrayList<>();

    public Trip(Date startDate, Date endDate, ParticipantExperience participantExperience, TripCategory tripCategory, List<ClimbingRock> climbingRocks) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantExperience = participantExperience;
        this.tripCategory = tripCategory;
        this.climbingRocks = climbingRocks;
    }

    public Trip() {

    }

    public List<ClimbingRock> getClimbingRocks() {
        return climbingRocks;
    }
}
