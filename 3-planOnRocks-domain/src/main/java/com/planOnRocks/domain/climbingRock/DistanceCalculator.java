package com.planOnRocks.domain.climbingRock;

import static java.lang.Math.*;

public class DistanceCalculator {

    public Distance getDistance(Location climbingRockLocation, Location userLocation){
        double distanceValue = calculateDistance(climbingRockLocation.getLatitude(), userLocation.getLatitude(),
                climbingRockLocation.getLongitude(), userLocation.getLongitude());

        return new Distance(distanceValue, DistanceUnit.KILOMETER);
    }

    private double calculateDistance(double climbingRockLocationLatitude, double userLocationLatitude,
                                       double climbingRockLocationLongitude, double userLocationLongitude) {
        return 6378.388 * acos(sin(climbingRockLocationLatitude) * sin(userLocationLatitude) +
                cos(climbingRockLocationLatitude) * cos(userLocationLatitude) * cos(abs(userLocationLongitude -
                        climbingRockLocationLongitude)));
    }
}