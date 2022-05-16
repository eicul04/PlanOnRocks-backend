package com.planOnRocks.plugins.trip.weatherAPI;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.WeatherAPI;
import com.planOnRocks.domain.trip.enums.Weather;
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
