package com.planOnRocks.adapters.trip;

import com.planOnRocks.domain.climbingRock.Bolting;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Difficulty;
import com.planOnRocks.domain.climbingRock.TripCategory;
import com.planOnRocks.domain.trip.ParticipantExperience;
import com.planOnRocks.domain.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripMapper {

    public Trip mapToTripEntity(TripDTO tripDTO) {
        List<ClimbingRock> climbingRockList = getClimbingRocksWithTripConditions(tripDTO.getParticipantExperience(), tripDTO.getTripCategory());
        return new Trip(tripDTO.getStartDate(), tripDTO.getEndDate(), tripDTO.getParticipantExperience(), tripDTO.getTripCategory(), climbingRockList);
    }

    private List<ClimbingRock> getClimbingRocksWithTripConditions(ParticipantExperience participantExperience, TripCategory tripCategory){
        List<ClimbingRock> filteredClimbingRocks = new ArrayList<>();
        // TODO filter ClimbingRocks in DB

        // ParticipantExperience.BEGINNER => Difficulty.EASY, Bolting.GOOD, Bolting.VERY_GOOD

        return filteredClimbingRocks;
    }
}
