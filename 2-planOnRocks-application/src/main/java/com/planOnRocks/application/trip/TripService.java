package com.planOnRocks.application.trip;

import com.planOnRocks.application.climbingRock.ClimbingRockFilterService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final ClimbingRockFilterService climbingRockFilterService;

    @Autowired
    public TripService(TripRepository tripRepository, ClimbingRockFilterService climbingRockFilterService) {
        this.tripRepository = tripRepository;
        this.climbingRockFilterService = climbingRockFilterService;
    }

    public List<ClimbingRock> createTrip(Trip trip, Location userLocation) {
        Trip savedTrip = tripRepository.save(getTripWithClimbingRockList(trip, userLocation));
        return savedTrip.getClimbingRocks();
    }

    private Trip getTripWithClimbingRockList(Trip trip, Location userLocation){
        List<ClimbingRock> climbingRocks = climbingRockFilterService.getClimbingRocksWithTripConditions(trip.getParticipantExperience(), trip.getTripCategory(), userLocation);
        return new Trip(trip.getStartDate(), trip.getEndDate(), trip.getParticipantExperience(), trip.getTripCategory(), climbingRocks);
    }
}
