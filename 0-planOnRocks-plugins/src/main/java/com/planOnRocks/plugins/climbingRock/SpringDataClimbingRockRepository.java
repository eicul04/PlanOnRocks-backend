package com.planOnRocks.plugins.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataClimbingRockRepository extends CrudRepository<ClimbingRock, Long> {

}
