package com.planOnRocks.domain.climbingRock.domainServices;

import com.planOnRocks.domain.climbingRock.valueObjects.Distance;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;

public interface DistanceCalculatorDomainService {

    Distance getDistance(Location climbingRockLocation, Location userLocation);

}
