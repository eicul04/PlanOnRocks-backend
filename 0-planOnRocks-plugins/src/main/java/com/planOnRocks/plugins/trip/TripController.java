package com.planOnRocks.plugins.trip;

import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.adapters.climbingRock.LocationMapper;
import com.planOnRocks.adapters.trip.TripDTO;
import com.planOnRocks.adapters.trip.TripMapper;
import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.TripCategory;
import com.planOnRocks.domain.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
    private final TripMapper tripMapper;
    private final LocationMapper locationMapper;

    @Autowired
    public TripController(TripService tripService, TripMapper tripMapper, LocationMapper locationMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
        this.locationMapper = locationMapper;
    }

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public Trip createTrip(@RequestBody TripDTO tripRequest) {
        return tripService.createTrip(tripMapper.apply(tripRequest));
    }

    @GetMapping(value = "/", params = {"climbingRock", "userLocation"}, produces = "application/json;charset=UTF-8")
    public List<ClimbingRock> getTripDestinations(@RequestParam Long climbingRockId, @RequestParam String userLocation) {
        return tripService.getTripDestinations(climbingRockId, locationMapper.apply(userLocation));
    }
}
