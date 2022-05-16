package com.planOnRocks.application.trip;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.enums.Weather;
import com.planOnRocks.domain.trip.WeatherAPI;
import com.planOnRocks.domain.trip.domainServices.WeatherDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class WeatherService implements WeatherDomainService {

    private final WeatherAPI weatherAPI;

    @Autowired
    public WeatherService(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public Weather getWeather(LocalDate tripStart, Location climbingRockLocation) {
        if(checkIfLessThanEightDays(tripStart)) {
            weatherAPI.getWeatherForDateAndLocation(tripStart, climbingRockLocation);
        }
        return Weather.NO_FORECAST;
    }

    private Boolean checkIfLessThanEightDays(LocalDate tripStart) {
        return DAYS.between(LocalDate.now(), tripStart) <= 8;
    }
}
