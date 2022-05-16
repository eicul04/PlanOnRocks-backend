package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClimbingRockToClimbingRockDTOMapper implements Function<ClimbingRock, ClimbingRockDTO> {

    private final LocationToStringMapper locationToStringMapper;

    @Autowired
    public ClimbingRockToClimbingRockDTOMapper(
            LocationToStringMapper locationToStringMapper) {
        this.locationToStringMapper = locationToStringMapper;
    }

    @Override
    public ClimbingRockDTO apply(ClimbingRock climbingRock) {
        return map(climbingRock);
    }

    private ClimbingRockDTO map(ClimbingRock climbingRock) {
        return new ClimbingRockDTO(locationToStringMapper.apply(climbingRock.getClimbingRockLocation()), climbingRock.getName(),
                                   climbingRock.getDifficulty(), climbingRock.getBolting());
    }
}
