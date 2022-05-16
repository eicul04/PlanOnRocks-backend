package com.planOnRocks.plugins.climbingRock;

import com.planOnRocks.adapters.climbingRock.ClimbingRockMapper;
import com.planOnRocks.adapters.climbingRock.ClimbingRockDTO;
import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.Location;
import com.planOnRocks.domain.climbingRock.TripCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/climbingRock")
public class ClimbingRockController {

    private final ClimbingRockService climbingRockService;
    private final ClimbingRockMapper climbingRockMapper;

    @Autowired
    public ClimbingRockController(ClimbingRockService climbingRockService, ClimbingRockMapper climbingRockMapper) {
        this.climbingRockService = climbingRockService;
        this.climbingRockMapper = climbingRockMapper;
    }


    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ClimbingRock createClimbingRock(@RequestBody ClimbingRockDTO climbingRockRequest) {
        return climbingRockService.saveClimbingRock(climbingRockMapper.mapToClimbingRockEntity(climbingRockRequest));
    }

    @GetMapping(value = "/{userLocation}", params = "climbingRock", produces = "application/json;charset=UTF-8")
    public TripCategory categorizeClimbingRock(@RequestParam ClimbingRock climbingRock, @PathVariable Location userLocation) {
        return climbingRockService.categorizeClimbingRock(climbingRock, userLocation);
    }
}
