package com.planOnRocks.application;

import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.application.trip.WeatherService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.enums.Bolting;
import com.planOnRocks.domain.climbingRock.enums.Difficulty;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import com.planOnRocks.domain.trip.enums.ParticipantExperience;
import com.planOnRocks.domain.trip.enums.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TripServiceTest {

    private static final ParticipantExperience PARTICIPANT_EXPERIENCE = ParticipantExperience.BEGINNER;
    private final TripCategory TRIP_CATEGORY = TripCategory.DAY_TRIP;
    private final LocalDate START_DATE = LocalDate.now();
    private final LocalDate END_DATE = LocalDate.now();
    private static final Long CLIMBING_ROCK_ID = 1L;
    private static final Long TRIP_ID = 1L;
    private static final String NAME = "Gausbach";
    private static final double LATITUDE_GAUSBACH = 48.68984755044936;
    private static final double LONGITUDE_GAUSBACH = 8.362811253038053;
    private static final Location LOCATION = new Location(LATITUDE_GAUSBACH, LONGITUDE_GAUSBACH);
    @Mock
    TripRepository tripRepository;
    @Mock
    ClimbingRockService climbingRockService;
    @Mock
    WeatherService weatherService;
    @InjectMocks
    TripService tripService;

    @Test
    void createTrip() {
        Trip tripMock = new Trip(START_DATE, END_DATE, PARTICIPANT_EXPERIENCE, TRIP_CATEGORY);

        doReturn(tripMock).when(tripRepository).save(tripMock);
        Trip savedTrip = tripService.createTrip(tripMock);

        verify(tripRepository, times(1)).save(any(Trip.class));
        assertEquals(tripMock, savedTrip);
    }

    @Test
    void getWeather() {
        ClimbingRock climbingRockMock = new ClimbingRock(LOCATION, NAME, Difficulty.EASY, Bolting.VERY_GOOD);
        Trip tripMock = new Trip(START_DATE, END_DATE, PARTICIPANT_EXPERIENCE, TRIP_CATEGORY);

        doReturn(climbingRockMock).when(climbingRockService).getClimbingRockById(CLIMBING_ROCK_ID);
        doReturn(tripMock).when(tripRepository).getTripById(TRIP_ID);
        doReturn(Weather.SUN).when(weatherService).getWeather(tripMock.getStartDate(), climbingRockMock.getClimbingRockLocation());

        Weather weather = tripService.getWeather(TRIP_ID, CLIMBING_ROCK_ID);
        assertEquals(Weather.SUN, weather);
    }
}
