package com.planOnRocks.domain.climbingRock;

public interface TripCategorizerDomainService {

    TripCategory getTripCategory(ClimbingRock climbingRock, Location userLocation);

}
