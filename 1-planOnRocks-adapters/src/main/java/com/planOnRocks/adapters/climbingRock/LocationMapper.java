package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationMapper implements Function<String, Location> {

    private Location mapToLocation(String location) {
        String[] latlong = location.split(",");
        double latitude = Double.parseDouble(latlong[0]);
        double longitude = Double.parseDouble(latlong[1]);
        return new Location(latitude, longitude);
    }

    @Override
    public Location apply(String location) {
        return mapToLocation(location);
    }
}
