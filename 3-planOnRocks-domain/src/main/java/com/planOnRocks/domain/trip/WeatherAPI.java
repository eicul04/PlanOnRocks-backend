package com.planOnRocks.domain.trip;

import com.planOnRocks.domain.climbingRock.Location;

import java.time.LocalDate;

public interface WeatherAPI {

    Weather getWeatherForDateAndLocation(LocalDate tripStart, Location location);
}
