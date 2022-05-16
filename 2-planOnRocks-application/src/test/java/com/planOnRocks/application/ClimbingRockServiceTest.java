package com.planOnRocks.application;

import com.planOnRocks.application.climbingRock.ClimbingRockService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import com.planOnRocks.domain.climbingRock.enums.Bolting;
import com.planOnRocks.domain.climbingRock.enums.Difficulty;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ClimbingRockServiceTest {

    private static final String NAME = "Gausbach";
    private static final double LATITUDE_GAUSBACH = 48.68984755044936;
    private static final double LONGITUDE_GAUSBACH = 8.362811253038053;
    private static final Location LOCATION = new Location(LATITUDE_GAUSBACH, LONGITUDE_GAUSBACH);
    @Mock
    ClimbingRockRepository climbingRockRepository;
    @InjectMocks
    ClimbingRockService climbingRockService;

    @Test
    void saveClimbingRock() {
        ClimbingRock climbingRockMock = new ClimbingRock(LOCATION, NAME, Difficulty.EASY, Bolting.VERY_GOOD);
        doReturn(climbingRockMock).when(this.climbingRockRepository).save(climbingRockMock);

        ClimbingRock savedClimbingRock = this.climbingRockService.saveClimbingRock(climbingRockMock);

        verify(this.climbingRockRepository, times(1)).save(any(ClimbingRock.class));
        assertEquals(climbingRockMock, savedClimbingRock);
    }

}
