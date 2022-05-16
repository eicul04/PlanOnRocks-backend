package com.planOnRocks.application;

import com.planOnRocks.application.climbingRock.DistanceCalculatorService;
import com.planOnRocks.application.climbingRock.TripCategorizerService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.enums.Bolting;
import com.planOnRocks.domain.climbingRock.enums.Difficulty;
import com.planOnRocks.domain.climbingRock.enums.DistanceUnit;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.climbingRock.valueObjects.Distance;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TripCategorizerServiceTest {

    private static final String NAME = "Gausbach";
    private static final double LATITUDE_GAUSBACH = 48.68984755044936;
    private static final double LONGITUDE_GAUSBACH = 8.362811253038053;
    private static final Location CLIMBING_ROCK_LOCATION = new Location(LATITUDE_GAUSBACH, LONGITUDE_GAUSBACH);
    ;
    private static final ClimbingRock CLIMBING_ROCK =
            new ClimbingRock(CLIMBING_ROCK_LOCATION, NAME, Difficulty.EASY, Bolting.VERY_GOOD);
    private static final Location USER_LOCATION = new Location(48.997648, 8.401793);

    @Mock
    DistanceCalculatorService distanceCalculator;

    @InjectMocks
    TripCategorizerService tripCategorizerService;

    @Test
    void categorizeClimbingRock() {
        when(distanceCalculator.getDistance(CLIMBING_ROCK_LOCATION, USER_LOCATION)).thenReturn(new Distance(35, DistanceUnit.KILOMETER));
        TripCategory tripCategory = tripCategorizerService.getTripCategory(CLIMBING_ROCK, USER_LOCATION);
        assertEquals(TripCategory.HALF_DAY_TRIP, tripCategory);
    }
}
