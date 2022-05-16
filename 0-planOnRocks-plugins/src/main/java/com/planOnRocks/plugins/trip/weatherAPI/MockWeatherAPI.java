package com.planOnRocks.plugins.trip.weatherAPI;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.enums.Weather;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MockWeatherAPI {

    public Weather getWeatherForDateAndLocation(LocalDate tripStart, Location location) {
        return Weather.SUN;
    }
}
