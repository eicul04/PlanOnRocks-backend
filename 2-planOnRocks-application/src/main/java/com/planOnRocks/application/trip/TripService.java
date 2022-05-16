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

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<ClimbingRock> getTripDestinations(Long tripId, Location userLocation) {
        Trip trip = getTripById(tripId);
        return climbingRockFilterService.getClimbingRocksWithTripConditions(trip.getParticipantExperience(), trip.getTripCategory(), userLocation);
    }

    private Trip getTripById(Long tripId) {
        return tripRepository.getTripById(tripId);
    }
}

