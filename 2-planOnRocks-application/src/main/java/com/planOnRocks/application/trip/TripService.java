package com.planOnRocks.application.trip;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<ClimbingRock> createTrip(Trip trip) {
        Trip savedTrip = tripRepository.save(trip);
        return savedTrip.getClimbingRocks();
    }
}
