package com.planOnRocks.plugins.trip;

import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.trip.Weather;
import com.planOnRocks.domain.trip.WeatherAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WeatherAPIBridge implements WeatherAPI {

    private final MockWeatherAPI mockWeatherAPI;

    @Autowired
    public WeatherAPIBridge(MockWeatherAPI mockWeatherAPI) {
        this.mockWeatherAPI = mockWeatherAPI;
    }

    @Override
    public Weather getWeatherForDateAndLocation(LocalDate tripStart, Location location) {
        return mockWeatherAPI.getWeatherForDateAndLocation(tripStart, location);
    }
}
