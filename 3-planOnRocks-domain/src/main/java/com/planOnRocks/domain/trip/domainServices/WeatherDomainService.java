package com.planOnRocks.domain.trip.domainServices;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.enums.Weather;

import java.time.LocalDate;

public interface WeatherDomainService {

    Weather getWeather(LocalDate tripStart, Location climbingRockLocation);
}
