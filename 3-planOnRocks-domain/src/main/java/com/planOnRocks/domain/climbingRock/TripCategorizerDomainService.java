package com.planOnRocks.domain.climbingRock;

public interface TripCategorizerDomainService {

    TripCategory categorizeClimbingRock(ClimbingRock climbingRock, Location userLocation);
    TripCategory getTripCategory(Distance distance);
}
