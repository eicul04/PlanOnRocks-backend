package com.planOnRocks.domain.climbingRock;

public class TripCategorizer {

    private DistanceCalculator destinationCalculator;

    public TripCategory categorizeClimbingRock(ClimbingRock climbingRock, Location userLocation) {
        Location climbingRockLocation = climbingRock.getClimbingRockLocation();
        Distance destination = destinationCalculator.getDistance(climbingRockLocation, userLocation);
        // TODO Logik implementieren, grade noch Mock
        if(destination.getValue() > 5) {
            return TripCategory.DAY_TRIP;
        }
        return TripCategory.HALF_DAY_TRIP;
    }
}
