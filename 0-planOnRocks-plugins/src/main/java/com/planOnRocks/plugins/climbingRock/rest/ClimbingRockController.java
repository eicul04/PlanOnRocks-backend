package com.planOnRocks.plugins.climbingRock.rest;

import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.adapters.climbingRock.ClimbingRockMapper;
import com.planOnRocks.adapters.climbingRock.LocationMapper;
import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/climbingRock")
public class ClimbingRockController {

    private final ClimbingRockService climbingRockService;
    private final ClimbingRockMapper climbingRockMapper;
    private final LocationMapper locationMapper;

    @Autowired
    public ClimbingRockController(ClimbingRockService climbingRockService, ClimbingRockMapper climbingRockMapper,
                                  LocationMapper locationMapper) {
        this.climbingRockService = climbingRockService;
        this.climbingRockMapper = climbingRockMapper;
        this.locationMapper = locationMapper;
    }


    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ClimbingRock createClimbingRock(@RequestBody ClimbingRockDTO climbingRockRequest) {
        return climbingRockService.saveClimbingRock(climbingRockMapper.apply(climbingRockRequest));
    }

    @GetMapping(value = "/", params = {"climbingRock", "userLocation"}, produces = "application/json;charset=UTF-8")
    public TripCategory categorizeClimbingRock(@RequestParam Long climbingRockId, @RequestParam String userLocation) {
        return climbingRockService.categorizeClimbingRock(climbingRockId, locationMapper.apply(userLocation));
    }
}
