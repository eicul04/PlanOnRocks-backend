package com.planOnRocks.plugins.trip;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TripRepositoryBridge implements TripRepository {

    private final SpringDataTripRepository springDataTripRepository;

    @Autowired
    public TripRepositoryBridge(SpringDataTripRepository springDataTripRepository) {
        this.springDataTripRepository = springDataTripRepository;
    }

    @Override
    public Trip save(Trip trip) {
        return this.springDataTripRepository.save(trip);
    }
}
