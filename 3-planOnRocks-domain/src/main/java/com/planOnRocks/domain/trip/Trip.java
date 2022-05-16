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

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "trip_climbingRock",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "location"))
    private List<ClimbingRock> climbingRocks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
