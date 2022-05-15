package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import com.planOnRocks.domain.destination.Location;
import com.planOnRocks.domain.destination.TripCategorizer;
import com.planOnRocks.domain.destination.TripCategory;
import org.springframework.stereotype.Service;

@Service
public class ClimbingRockService {

    private ClimbingRockRepository climbingRockRepository;

    private TripCategorizer tripCategorizer;

    public ClimbingRock saveClimbingRock(ClimbingRock climbingRock) {
        return climbingRockRepository.save(climbingRock);
    }

    public TripCategory categorizeClimbingRock(ClimbingRock climbingRock, Location userLocation) {
        return tripCategorizer.categorizeClimbingRock(climbingRock, userLocation);
    }
}
