package com.planOnRocks.adapters.trip;

import com.planOnRocks.domain.climbingRock.*;
import com.planOnRocks.domain.trip.ParticipantExperience;
import com.planOnRocks.domain.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripMapper {

    private ClimbingRockRepository climbingRockRepository;

    public Trip mapToTripEntity(TripDTO tripDTO) {
        List<ClimbingRock> climbingRockList = getClimbingRocksWithTripConditions(tripDTO.getParticipantExperience(), tripDTO.getTripCategory());
        return new Trip(tripDTO.getStartDate(), tripDTO.getEndDate(), tripDTO.getParticipantExperience(), tripDTO.getTripCategory(), climbingRockList);
    }

    private List<ClimbingRock> getClimbingRocksWithTripConditions(ParticipantExperience participantExperience, TripCategory tripCategory){
        List<ClimbingRock> filteredClimbingRocks = new ArrayList<>();
        // TODO filter ClimbingRocks in DB



        return filteredClimbingRocks;
    }
}
