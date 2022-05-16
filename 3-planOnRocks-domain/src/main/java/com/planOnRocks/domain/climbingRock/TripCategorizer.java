package com.planOnRocks.domain.climbingRock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripCategorizer {

    @Autowired
    public TripCategorizer(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    private DistanceCalculator distanceCalculator;

    public TripCategory categorizeClimbingRock(ClimbingRock climbingRock, Location userLocation) {
        Location climbingRockLocation = climbingRock.getClimbingRockLocation();
        Distance distance = distanceCalculator.getDistance(climbingRockLocation, userLocation);
        return getTripCategory(distance);
    }

    private TripCategory getTripCategory(Distance distance) {
        if(distance.getValue() < 50) {
            return TripCategory.HALF_DAY_TRIP;
        }
        if(distance.getValue() < 140) {
            return TripCategory.DAY_TRIP;
        }
        if(distance.getValue() < 250) {
            return TripCategory.WEEKEND_TRIP;
        }
        return TripCategory.VACATION;
    }
}
