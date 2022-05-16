package com.planOnRocks.plugins.trip;

import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.trip.Weather;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MockWeatherAPI {

    public Weather getWeatherForDateAndLocation(LocalDate tripStart, Location location) {
        return Weather.SUN;
    }
}
