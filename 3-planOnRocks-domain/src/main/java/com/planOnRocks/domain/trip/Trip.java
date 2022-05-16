package com.planOnRocks.domain.trip;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.trip.enums.ParticipantExperience;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "trip")
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", nullable = false)
    private Long id;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name = "participantExperience")
    private ParticipantExperience participantExperience;

    @Column(name = "tripCategory")
    private TripCategory tripCategory;

    public Trip(LocalDate startDate, LocalDate endDate, ParticipantExperience participantExperience, TripCategory tripCategory) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantExperience = participantExperience;
        this.tripCategory = tripCategory;
    }

    public Trip() {

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ParticipantExperience getParticipantExperience() {
        return participantExperience;
    }

    public TripCategory getTripCategory() {
        return tripCategory;
    }
}
