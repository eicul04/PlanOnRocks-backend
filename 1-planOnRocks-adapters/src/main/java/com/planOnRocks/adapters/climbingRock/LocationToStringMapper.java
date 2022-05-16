package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationToStringMapper implements Function<Location, String> {

    @Override
    public String apply(Location location) {
        return map(location);
    }

    private String map(Location location) {
        return location.getLatitude() + ", " + location.getLongitude();
    }
}
