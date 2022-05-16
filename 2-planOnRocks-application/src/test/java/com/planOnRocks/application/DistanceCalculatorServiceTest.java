package com.planOnRocks.application;

import com.planOnRocks.application.climbingRock.DistanceCalculatorService;
import com.planOnRocks.domain.climbingRock.valueObjects.Distance;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DistanceCalculatorServiceTest {

    private static final double LATITUDE_1 = 52.51640;
    private static final double LATITUDE_2 = 13.37770;
    private static final double LONGITUDE_1 = 39.03484;
    private static final double LONGITUDE_2 = -2.849819;
    private static final Location CLIMBING_ROCK_LOCATION = new Location(LATITUDE_1, LONGITUDE_1);
    private static final Location USER_LOCATION = new Location(LATITUDE_2, LONGITUDE_2);

    @InjectMocks
    private DistanceCalculatorService distanceCalculator;

    @Test
    void getDistanceTest() {
        double shouldDistanceValue = 4296.663184788783;

        Distance distance = distanceCalculator.getDistance(CLIMBING_ROCK_LOCATION, USER_LOCATION);

        assertEquals(shouldDistanceValue, distance.getValue());
    }
}
