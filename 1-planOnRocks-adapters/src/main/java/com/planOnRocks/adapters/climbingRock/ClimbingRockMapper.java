package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Location;
import org.springframework.stereotype.Component;

@Component
public class ClimbingRockMapper {

    public ClimbingRock mapToClimbingRockEntity(ClimbingRockDTO climbingRockDTO) {
        Location location = convertToLocation(climbingRockDTO.getLocation());
        return new ClimbingRock(location, climbingRockDTO.getName(), climbingRockDTO.getDifficulty(), climbingRockDTO.getBolting());
    }

    private Location convertToLocation(String location) {
        String[] latlong = location.split(",");
        long latitude = Long.parseLong(latlong[0]);
        long longitude = Long.parseLong(latlong[1]);
        return new Location(latitude, longitude);
    }
}
