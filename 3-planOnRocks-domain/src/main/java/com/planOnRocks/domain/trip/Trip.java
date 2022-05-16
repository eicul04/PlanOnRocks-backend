package com.planOnRocks.domain.trip;
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

    public Trip(Date startDate, Date endDate, ParticipantExperience participantExperience, TripCategory tripCategory) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantExperience = participantExperience;
        this.tripCategory = tripCategory;
    }

    public Trip() {

    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ParticipantExperience getParticipantExperience() {
        return participantExperience;
    }

    public TripCategory getTripCategory() {
        return tripCategory;
    }
}
