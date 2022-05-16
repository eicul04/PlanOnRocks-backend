package com.planOnRocks.adapters.trip;

import com.planOnRocks.domain.trip.Trip;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TripToTripDTOMapper implements Function<Trip, TripDTO> {

    @Override
    public TripDTO apply(Trip trip) {
        return mapToTripDTO(trip);
    }

    private TripDTO mapToTripDTO(Trip trip) {
        return new TripDTO(trip.getParticipantExperience(), trip.getTripCategory(),
                           trip.getStartDate(), trip.getEndDate());
    }
}
