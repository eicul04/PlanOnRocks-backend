package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StringToLocationMapper implements Function<String, Location> {

    private Location mapToLocation(String location) {
        String[] latlong = location.split(",");
        return new Location(getLatitude(latlong), getLongitude(latlong));
    }

    private double getLongitude(String[] latlong) {
        return Double.parseDouble(latlong[1]);
    }

    private double getLatitude(String[] latlong) {
        return Double.parseDouble(latlong[0]);
    }

    @Override
    public Location apply(String location) {
        return mapToLocation(location);
    }
}
