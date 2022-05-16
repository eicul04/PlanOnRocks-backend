package com.planOnRocks.domain.climbingRock.domainServices;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;

public interface TripCategorizerDomainService {

    TripCategory getTripCategory(ClimbingRock climbingRock, Location userLocation);

}
