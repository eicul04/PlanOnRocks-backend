package com.planOnRocks.plugins.trip;

import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.adapters.trip.TripDTO;
import com.planOnRocks.adapters.trip.TripMapper;
import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
    private final TripMapper tripMapper;

    @Autowired
    public TripController(TripService tripService, TripMapper tripMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
    }

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public List<ClimbingRock> createTrip(@RequestBody TripDTO tripRequest) {
        return tripService.createTrip(tripMapper.apply(tripRequest));
    }
}
