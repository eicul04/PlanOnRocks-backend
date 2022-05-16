package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.domainServices.TripCategorizerDomainService;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.climbingRock.valueObjects.Distance;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripCategorizerService implements TripCategorizerDomainService {

    private final DistanceCalculatorService distanceCalculator;

    @Autowired
    public TripCategorizerService(DistanceCalculatorService distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public TripCategory getTripCategory(ClimbingRock climbingRock, Location userLocation) {
        Location climbingRockLocation = climbingRock.getClimbingRockLocation();
        Distance distance = distanceCalculator.getDistance(climbingRockLocation, userLocation);
        return categorizeClimbingRock(distance);
    }

    private TripCategory categorizeClimbingRock(Distance distance) {
        if (distance.getValue() < 50) {
            return TripCategory.HALF_DAY_TRIP;
        }
        if (distance.getValue() < 140) {
            return TripCategory.DAY_TRIP;
        }
        if (distance.getValue() < 250) {
            return TripCategory.WEEKEND_TRIP;
        }
        return TripCategory.VACATION;
    }
}
