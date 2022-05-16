package com.planOnRocks.adapters.trip;

import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.climbingRock.TripCategory;
import com.planOnRocks.domain.trip.ParticipantExperience;

import java.time.LocalDate;
import java.util.Date;

public class TripDTO {

    private final ParticipantExperience participantExperience;
    private final TripCategory tripCategory;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public ParticipantExperience getParticipantExperience() {
        return participantExperience;
    }

    public TripCategory getTripCategory() {
        return tripCategory;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public TripDTO(ParticipantExperience participantExperience, TripCategory tripCategory, LocalDate startDate, LocalDate endDate) {
        this.participantExperience = participantExperience;
        this.tripCategory = tripCategory;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
