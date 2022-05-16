package com.planOnRocks.domain.trip;

public interface TripRepository {

    Trip save(Trip trip);

    Trip getTripById(Long tripId);
}
