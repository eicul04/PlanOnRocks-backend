package com.planOnRocks.application;

import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.Bolting;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import com.planOnRocks.domain.climbingRock.Difficulty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ClimbingRockServiceTest {

    @Mock
    ClimbingRockRepository climbingRockRepository;

    @InjectMocks
    ClimbingRockService climbingRockService;

    private static final String NAME = "Gausbach";
    private static final double LATITUDE_GAUSBACH = 48.68984755044936;
    private static final double LONGITUDE_GAUSBACH = 8.362811253038053;


    @Test
    void saveClimbingRock() {
        ClimbingRock.Location location = new ClimbingRock.Location(LATITUDE_GAUSBACH, LONGITUDE_GAUSBACH);
        ClimbingRock climbingRockToSave = new ClimbingRock(location, NAME, Difficulty.EASY, Bolting.VERY_GOOD);
        doReturn(climbingRockToSave).when(this.climbingRockRepository).save(climbingRockToSave);

        ClimbingRock savedClimbingRock = this.climbingRockService.saveClimbingRock(climbingRockToSave);

        verify(this.climbingRockRepository, times(1)).save(any(ClimbingRock.class));
        assertEquals(climbingRockToSave, savedClimbingRock);
    }

}
