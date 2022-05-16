package com.planOnRocks.plugins.trip;

import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.adapters.climbingRock.LocationMapper;
import com.planOnRocks.adapters.trip.TripDTO;
import com.planOnRocks.adapters.trip.TripMapper;
import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
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

    @PostMapping(value = "", params = "userLocation", produces = "application/json;charset=UTF-8")
    public List<ClimbingRock> createTrip(@RequestBody TripDTO tripRequest, @RequestParam String userLocation) {
        return tripService.createTrip(tripMapper.apply(tripRequest), locationMapper.apply(userLocation));
    }
}
