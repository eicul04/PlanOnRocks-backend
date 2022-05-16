package com.planOnRocks.domain.climbingRock;

import com.planOnRocks.domain.trip.ParticipantExperience;

import java.util.List;

public interface ClimbingRockFilterDomainService {

    List<ClimbingRock> getClimbingRocksWithTripConditions(ParticipantExperience participantExperience, TripCategory tripCategory, Location userLocation);
}
