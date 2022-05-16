package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClimbingRockMapper implements Function<ClimbingRockDTO, ClimbingRock> {

    private final LocationMapper locationMapper;

    @Autowired
    public ClimbingRockMapper(LocationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    public ClimbingRock mapToClimbingRockEntity(ClimbingRockDTO climbingRockDTO) {
        return new ClimbingRock(locationMapper.apply(climbingRockDTO.getLocation()), climbingRockDTO.getName(), climbingRockDTO.getDifficulty(), climbingRockDTO.getBolting());
    }

    @Override
    public ClimbingRock apply(ClimbingRockDTO climbingRockDTO) {
        return this.mapToClimbingRockEntity(climbingRockDTO);
    }
}
