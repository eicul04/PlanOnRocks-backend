package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import org.springframework.stereotype.Service;

@Service
public class ClimbingRockService {

    private ClimbingRockRepository climbingRockRepository;

    public ClimbingRock saveClimbingRock(ClimbingRock climbingRock) {
        return climbingRockRepository.save(climbingRock);
    }
}
