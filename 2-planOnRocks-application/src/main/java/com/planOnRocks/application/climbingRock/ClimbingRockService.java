package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.climbingRock.TripCategory;
import com.planOnRocks.domain.trip.ParticipantExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimbingRockService {

    private final ClimbingRockRepository climbingRockRepository;

    private final TripCategorizerService tripCategorizer;

    @Autowired
    public ClimbingRockService(ClimbingRockRepository climbingRockRepository, TripCategorizerService tripCategorizer) {
        this.climbingRockRepository = climbingRockRepository;
        this.tripCategorizer = tripCategorizer;
    }

    public ClimbingRock saveClimbingRock(ClimbingRock climbingRock) {
        return climbingRockRepository.save(climbingRock);
    }

    public TripCategory categorizeClimbingRock(Long climbingRockId, Location userLocation) {
        return tripCategorizer.getTripCategory(getClimbingRockById(climbingRockId), userLocation);
    }

    public ClimbingRock getClimbingRockById(Long climbingRockId) {
        return climbingRockRepository.getClimbingRockById(climbingRockId);
    }
}
