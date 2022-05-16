package com.planOnRocks.adapters.trip;

import com.planOnRocks.domain.climbingRock.TripCategory;
import com.planOnRocks.domain.trip.ParticipantExperience;

import java.util.Date;

public class TripDTO {

    private ParticipantExperience participantExperience;
    private TripCategory tripCategory;
    private Date startDate;
    private Date endDate;

    public ParticipantExperience getParticipantExperience() {
        return participantExperience;
    }

    public TripCategory getTripCategory() {
        return tripCategory;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public TripDTO(ParticipantExperience participantExperience, TripCategory tripCategory, Date startDate, Date endDate) {
        this.participantExperience = participantExperience;
        this.tripCategory = tripCategory;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
