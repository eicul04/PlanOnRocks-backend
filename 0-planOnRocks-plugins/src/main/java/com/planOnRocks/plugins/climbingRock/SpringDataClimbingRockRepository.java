package com.planOnRocks.plugins.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRock.Location;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataClimbingRockRepository extends CrudRepository<ClimbingRock, Location> {

}
