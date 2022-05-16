package com.planOnRocks.domain.trip;

import com.planOnRocks.domain.climbingRock.Location;

import java.time.LocalDate;

public interface WeatherAPI {

    void getWeatherForDateAndLocation(LocalDate tripStart, Location location);
}
