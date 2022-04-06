package com.planOnRocks.plugins.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClimbingRockRepositoryBridge implements ClimbingRockRepository {

    private SpringDataClimbingRockRepository springDataClimbingRockRepository;

    public ClimbingRockRepositoryBridge(SpringDataClimbingRockRepository springDataClimbingRockRepository) {
        this.springDataClimbingRockRepository = springDataClimbingRockRepository;
    }

    @Override
    public ClimbingRock save(ClimbingRock climbingRock) {
        return this.springDataClimbingRockRepository.save(climbingRock);
    }
}
