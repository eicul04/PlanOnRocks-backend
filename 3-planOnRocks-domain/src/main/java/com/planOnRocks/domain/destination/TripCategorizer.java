package com.planOnRocks.domain.destination;

import com.planOnRocks.domain.climbingRock.ClimbingRock;

public class TripCategorizer {

    private DistanceCalculator destinationCalculator;

    public TripCategory categorizeClimbingRock(ClimbingRock climbingRock, Location userLocation) {
        Distance destination = destinationCalculator.getDistance(climbingRock, userLocation);
        // TODO Logik implementieren, grade noch Mock
        if(destination.getValue() > 5) {
            return TripCategory.DAY_TRIP;
        }
        return TripCategory.HALF_DAY_TRIP;
    }
}
