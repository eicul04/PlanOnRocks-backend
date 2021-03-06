package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClimbingRockDTOToClimbingRockMapper implements Function<ClimbingRockDTO, ClimbingRock> {

    private final StringToLocationMapper locationMapper;

    @Autowired
    public ClimbingRockDTOToClimbingRockMapper(StringToLocationMapper locationMapper) {
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
