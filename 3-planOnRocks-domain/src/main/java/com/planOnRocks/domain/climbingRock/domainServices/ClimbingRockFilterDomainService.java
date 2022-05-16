package com.planOnRocks.domain.climbingRock.domainServices;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.climbingRock.TripCategory;
import com.planOnRocks.domain.trip.ParticipantExperience;

import java.util.List;

public interface ClimbingRockFilterDomainService {

    List<ClimbingRock> getClimbingRocksWithTripConditions(ParticipantExperience participantExperience, TripCategory tripCategory, Location userLocation);
}
