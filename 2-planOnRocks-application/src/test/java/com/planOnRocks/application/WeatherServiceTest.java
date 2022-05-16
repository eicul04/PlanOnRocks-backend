package com.planOnRocks.application;

import com.planOnRocks.application.trip.WeatherService;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.WeatherAPI;
import com.planOnRocks.domain.trip.enums.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    private final LocalDate TRIP_START_IN_ONE_DAY = LocalDate.now().plusDays(1);
    private final LocalDate TRIP_START_DATE_IN_TEN_DAYS = LocalDate.now().plusDays(10);
    private static final double LATITUDE_GAUSBACH = 48.68984755044936;
    private static final double LONGITUDE_GAUSBACH = 8.362811253038053;
    private static final Location CLIMBING_ROCK_LOCATION = new Location(LATITUDE_GAUSBACH, LONGITUDE_GAUSBACH);

    @Mock
    WeatherAPI weatherAPI;

    @InjectMocks
    WeatherService weatherService;

    @Test
    void getWeatherIfLessThanEightDays() {
        doReturn(Weather.SUN).when(weatherAPI).getWeatherForDateAndLocation(TRIP_START_IN_ONE_DAY, CLIMBING_ROCK_LOCATION);
        Weather weatherResult = weatherService.getWeather(TRIP_START_IN_ONE_DAY, CLIMBING_ROCK_LOCATION);
        assertEquals(Weather.SUN, weatherResult);
    }

    @Test
    void getNoForecastIfMoreThanEightDays() {
        Weather weatherResult = weatherService.getWeather(TRIP_START_DATE_IN_TEN_DAYS, CLIMBING_ROCK_LOCATION);
        assertEquals(Weather.NO_FORECAST, weatherResult);
    }
}
