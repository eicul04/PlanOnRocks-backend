package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripCategorizerService implements TripCategorizerDomainService {

    @Autowired
    public TripCategorizerService(DistanceCalculatorService distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    private final DistanceCalculatorService distanceCalculator;

    public TripCategory getTripCategory(ClimbingRock climbingRock, Location userLocation) {
        Location climbingRockLocation = climbingRock.getClimbingRockLocation();
        Distance distance = distanceCalculator.getDistance(climbingRockLocation, userLocation);
        return categorizeClimbingRock(distance);
    }

    public TripCategory categorizeClimbingRock(Distance distance) {
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
