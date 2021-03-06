package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.domainServices.DistanceCalculatorDomainService;
import com.planOnRocks.domain.climbingRock.enums.DistanceUnit;
import com.planOnRocks.domain.climbingRock.valueObjects.Distance;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.springframework.stereotype.Service;

import static java.lang.Math.*;

@Service
public class DistanceCalculatorService implements DistanceCalculatorDomainService {

    public Distance getDistance(Location climbingRockLocation, Location userLocation) {
        double distanceValue = calculateDistance(climbingRockLocation.getLatitude(), userLocation.getLatitude(),
                                                 climbingRockLocation.getLongitude(), userLocation.getLongitude());

        return new Distance(distanceValue, DistanceUnit.KILOMETER);
    }

    private double calculateDistance(double climbingRockLocationLatitude, double userLocationLatitude,
                                     double climbingRockLocationLongitude, double userLocationLongitude) {
        return 6378.388 * acos(sin(climbingRockLocationLatitude) * sin(userLocationLatitude) + cos(climbingRockLocationLatitude)
                * cos(userLocationLatitude) * cos(abs(userLocationLongitude - climbingRockLocationLongitude)));
    }
}
