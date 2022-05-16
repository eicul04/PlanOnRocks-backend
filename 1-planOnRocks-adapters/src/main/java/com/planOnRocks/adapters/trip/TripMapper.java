package com.planOnRocks.adapters.trip;

import com.planOnRocks.domain.trip.Trip;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TripMapper implements Function<TripDTO, Trip> {

    public Trip mapToTripEntity(TripDTO tripDTO) {
        return new Trip(tripDTO.getStartDate(), tripDTO.getEndDate(), tripDTO.getParticipantExperience(), tripDTO.getTripCategory());
    }

    @Override
    public Trip apply(TripDTO tripDTO) {
        return this.mapToTripEntity(tripDTO);
    }
}
