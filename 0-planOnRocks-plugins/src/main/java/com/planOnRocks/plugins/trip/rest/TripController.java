package com.planOnRocks.plugins.trip.rest;

import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.adapters.climbingRock.ClimbingRockToClimbingRockDTOMapper;
import com.planOnRocks.adapters.climbingRock.StringToLocationMapper;
import com.planOnRocks.adapters.trip.TripDTO;
import com.planOnRocks.adapters.trip.TripDTOToTripMapper;
import com.planOnRocks.adapters.trip.TripToTripDTOMapper;
import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.trip.enums.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
    private final TripDTOToTripMapper tripDTOToTripMapper;
    private final TripToTripDTOMapper tripToTripDTOMapper;
    private final StringToLocationMapper locationMapper;
    private final ClimbingRockToClimbingRockDTOMapper climbingRockToClimbingRockDTOMapper;

    @Autowired
    public TripController(TripService tripService, TripDTOToTripMapper tripMapper,
                          TripToTripDTOMapper tripToTripDTOMapper,
                          StringToLocationMapper locationMapper,
                          ClimbingRockToClimbingRockDTOMapper climbingRockToClimbingRockDTOMapper) {
        this.tripService = tripService;
        this.tripDTOToTripMapper = tripMapper;
        this.tripToTripDTOMapper = tripToTripDTOMapper;
        this.locationMapper = locationMapper;
        this.climbingRockToClimbingRockDTOMapper = climbingRockToClimbingRockDTOMapper;
    }

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public TripDTO createTrip(@RequestBody TripDTO tripRequest) {
        return tripToTripDTOMapper.apply(tripService.createTrip(tripDTOToTripMapper.apply(tripRequest)));
    }

    @GetMapping(value = "/", params = {"climbingRock", "userLocation"}, produces = "application/json;charset=UTF-8")
    public List<ClimbingRockDTO> getTripDestinations(@RequestParam Long climbingRockId,
                                                     @RequestParam String userLocation) {
        return tripService.getTripDestinations(climbingRockId, locationMapper.apply(userLocation))
                .stream().map(climbingRockToClimbingRockDTOMapper)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/", params = {"tripId", "climbingRockId"}, produces = "application/json;charset=UTF-8")
    public Weather getWeather(@RequestParam Long tripId, @RequestParam Long climbingRockId) {
        return tripService.getWeather(tripId, climbingRockId);
    }
}
