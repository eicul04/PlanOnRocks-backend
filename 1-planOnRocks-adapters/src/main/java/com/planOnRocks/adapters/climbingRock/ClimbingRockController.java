package com.planOnRocks.adapters.climbingRock;

import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/climbingRock")
public class ClimbingRockController {

    private ClimbingRockService climbingRockService;
    private ClimbingRockMapper climbingRockMapper;

    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ClimbingRock createClimbingRock(@RequestBody ClimbingRockResource climbingRockRequest) {
        return climbingRockService.saveClimbingRock(climbingRockMapper.mapToClimbingRockEntity(climbingRockRequest));
    }

}
