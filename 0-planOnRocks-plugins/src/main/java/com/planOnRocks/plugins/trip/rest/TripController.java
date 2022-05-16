package com.planOnRocks.plugins.trip.rest;

import com.planOnRocks.adapters.climbingRock.LocationMapper;
import com.planOnRocks.adapters.trip.TripDTO;
import com.planOnRocks.adapters.trip.TripDTOToTripMapper;
import com.planOnRocks.adapters.trip.TripToTripDTOMapper;
import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.enums.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
    private final TripDTOToTripMapper tripDTOToTripMapper;
    private final TripToTripDTOMapper tripToTripDTOMapper;
    private final LocationMapper locationMapper;

    @Autowired
    public TripController(TripService tripService, TripDTOToTripMapper tripMapper,
                          TripToTripDTOMapper tripToTripDTOMapper,
                          LocationMapper locationMapper) {
        this.tripService = tripService;
        this.tripDTOToTripMapper = tripMapper;
        this.tripToTripDTOMapper = tripToTripDTOMapper;
        this.locationMapper = locationMapper;
    }

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public TripDTO createTrip(@RequestBody TripDTO tripRequest) {
        return tripToTripDTOMapper.apply(tripService.createTrip(tripDTOToTripMapper.apply(tripRequest)));
    }

    @GetMapping(value = "/", params = {"climbingRock", "userLocation"}, produces = "application/json;charset=UTF-8")
    public List<ClimbingRock> getTripDestinations(@RequestParam Long climbingRockId,
                                                  @RequestParam String userLocation) {
        return tripService.getTripDestinations(climbingRockId, locationMapper.apply(userLocation));
    }

    @GetMapping(value = "/", params = {"tripId", "climbingRockId"}, produces = "application/json;charset=UTF-8")
    public Weather getWeather(@RequestParam Long tripId, @RequestParam Long climbingRockId) {
        return tripService.getWeather(tripId, climbingRockId);
    }
}
