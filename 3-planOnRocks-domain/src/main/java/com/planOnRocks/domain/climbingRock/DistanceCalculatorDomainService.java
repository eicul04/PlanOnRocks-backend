package com.planOnRocks.domain.climbingRock;

public interface DistanceCalculatorDomainService {

    Distance getDistance(Location climbingRockLocation, Location userLocation);

}
