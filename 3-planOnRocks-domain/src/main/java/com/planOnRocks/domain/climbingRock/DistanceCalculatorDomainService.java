package com.planOnRocks.domain.climbingRock;

public interface DistanceCalculatorDomainService {

    Distance getDistance(Location climbingRockLocation, Location userLocation);

    double calculateDistance(double climbingRockLocationLatitude, double userLocationLatitude,
                             double climbingRockLocationLongitude, double userLocationLongitude);
}
