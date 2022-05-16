package com.planOnRocks.domain.trip;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.enums.Weather;

import java.time.LocalDate;

public interface WeatherAPI {

    Weather getWeatherForDateAndLocation(LocalDate tripStart, Location location);
}
