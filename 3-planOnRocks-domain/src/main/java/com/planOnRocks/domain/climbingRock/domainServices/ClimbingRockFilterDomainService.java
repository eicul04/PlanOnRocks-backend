package com.planOnRocks.domain.climbingRock.domainServices;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.enums.ParticipantExperience;

import java.util.List;

public interface ClimbingRockFilterDomainService {

    List<ClimbingRock> getClimbingRocksWithTripConditions(ParticipantExperience participantExperience,
                                                          TripCategory tripCategory, Location userLocation);
}
