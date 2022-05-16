package com.planOnRocks.domain.trip;

import com.planOnRocks.domain.climbingRock.Location;

import java.time.LocalDate;

public interface WeatherDomainService {

    Weather getWeather(LocalDate tripStart, Location climbingRockLocation);
}
