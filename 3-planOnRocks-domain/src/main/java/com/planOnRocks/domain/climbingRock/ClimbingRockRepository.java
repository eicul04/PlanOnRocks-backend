package com.planOnRocks.domain.climbingRock;

import java.util.List;

public interface ClimbingRockRepository {

    ClimbingRock save(ClimbingRock climbingRock);

    List<ClimbingRock> getClimbingRocksForBeginnerParticipants();
    List<ClimbingRock> getClimbingRocksForAdvancedParticipants();
    List<ClimbingRock> getClimbingRocksForProfessionalParticipants();
}
