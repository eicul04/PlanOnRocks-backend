package com.planOnRocks.application.trip;

import com.planOnRocks.application.climbingRock.ClimbingRockFilterService;
import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import com.planOnRocks.domain.trip.enums.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final ClimbingRockFilterService climbingRockFilterService;
    private final ClimbingRockService climbingRockService;
    private final WeatherService weatherService;

    @Autowired
    public TripService(TripRepository tripRepository, ClimbingRockFilterService climbingRockFilterService,
                       ClimbingRockService climbingRockService, WeatherService weatherService) {
        this.tripRepository = tripRepository;
        this.climbingRockFilterService = climbingRockFilterService;
        this.climbingRockService = climbingRockService;
        this.weatherService = weatherService;
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<ClimbingRock> getTripDestinations(Long tripId, Location userLocation) {
        Trip trip = getTripById(tripId);
        return climbingRockFilterService.getClimbingRocksWithTripConditions(trip.getParticipantExperience(), trip.getTripCategory(), userLocation);
    }

    public Weather getWeather(Long tripId, Long climbingRockId) {
        Trip trip = getTripById(tripId);
        ClimbingRock climbingRock = climbingRockService.getClimbingRockById(climbingRockId);
        return weatherService.getWeather(trip.getStartDate(), climbingRock.getClimbingRockLocation());
    }

    private Trip getTripById(Long tripId) {
        return tripRepository.getTripById(tripId);
    }
}

