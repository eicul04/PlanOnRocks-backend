package com.planOnRocks.plugins.climbingRock.rest;

import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.adapters.climbingRock.ClimbingRockDTOToClimbingRockMapper;
import com.planOnRocks.adapters.climbingRock.ClimbingRockToClimbingRockDTOMapper;
import com.planOnRocks.adapters.climbingRock.StringToLocationMapper;
import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/climbingRock")
public class ClimbingRockController {

    private final ClimbingRockService climbingRockService;
    private final ClimbingRockDTOToClimbingRockMapper climbingRockDTOToClimbingRockMapper;
    private final ClimbingRockToClimbingRockDTOMapper climbingRockToClimbingRockDTOMapper;
    private final StringToLocationMapper stringToLocationMapper;

    @Autowired
    public ClimbingRockController(ClimbingRockService climbingRockService,
                                  ClimbingRockDTOToClimbingRockMapper climbingRockMapper,
                                  ClimbingRockToClimbingRockDTOMapper climbingRockToClimbingRockDTOMapper,
                                  StringToLocationMapper locationMapper) {
        this.climbingRockService = climbingRockService;
        this.climbingRockDTOToClimbingRockMapper = climbingRockMapper;
        this.climbingRockToClimbingRockDTOMapper = climbingRockToClimbingRockDTOMapper;
        this.stringToLocationMapper = locationMapper;
    }


    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ClimbingRockDTO createClimbingRock(@RequestBody ClimbingRockDTO climbingRockRequest) {
        return climbingRockToClimbingRockDTOMapper.apply(climbingRockService.saveClimbingRock(
                climbingRockDTOToClimbingRockMapper.apply(climbingRockRequest)));
    }

    @GetMapping(value = "/", params = {"climbingRock", "userLocation"}, produces = "application/json;charset=UTF-8")
    public TripCategory categorizeClimbingRock(@RequestParam Long climbingRockId, @RequestParam String userLocation) {
        return climbingRockService.categorizeClimbingRock(climbingRockId, stringToLocationMapper.apply(userLocation));
    }
}
