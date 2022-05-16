package com.planOnRocks.application;

import com.planOnRocks.application.climbingRock.ClimbingRockFilterService;
import com.planOnRocks.application.climbingRock.TripCategorizerService;
import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import com.planOnRocks.domain.climbingRock.enums.Bolting;
import com.planOnRocks.domain.climbingRock.enums.Difficulty;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.climbingRock.valueObjects.Location;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.enums.ParticipantExperience;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ClimbingRockFilterServiceTest {

    @Mock
    ClimbingRockRepository climbingRockRepository;

    @Mock
    TripCategorizerService tripCategorizerService;

    @InjectMocks
    ClimbingRockFilterService climbingRockFilterService;

    private static final double LATITUDE_1 = 52.51640;
    private static final double LATITUDE_2 = 13.37770;
    private static final double LONGITUDE_1 = 39.03484;
    private static final double LONGITUDE_2 = -2.849819;
    private static final Location CLIMBING_ROCK_LOCATION = new Location(LATITUDE_1, LONGITUDE_1);
    private static final Location USER_LOCATION = new Location(LATITUDE_2, LONGITUDE_2);
    private static final TripCategory TRIP_CATEGORY = TripCategory.DAY_TRIP;
    private static final String NAME = "Gausbach";
    private static final ParticipantExperience PARTICIPANT_EXPERIENCE_BEGINNER = ParticipantExperience.BEGINNER;
    private static final ParticipantExperience PARTICIPANT_EXPERIENCE_ADVANCED = ParticipantExperience.ADVANCED;
    private static final ParticipantExperience PARTICIPANT_EXPERIENCE_PROFESSIONAL = ParticipantExperience.PROFESSIONAL;

    private List<ClimbingRock> climbingRockListMock;
    private ClimbingRock climbingRockMock;

    @BeforeEach
    void init() {
        this.climbingRockMock = new ClimbingRock(CLIMBING_ROCK_LOCATION, NAME, Difficulty.EASY, Bolting.VERY_GOOD);
        this.climbingRockListMock = new ArrayList<>();
        climbingRockListMock.add(climbingRockMock);
    }

    @Test
    void getClimbingRocksWithParticipantExperienceBeginner() {
        doReturn(climbingRockListMock).when(climbingRockRepository).getClimbingRocksForBeginnerParticipants();
        doReturn(TRIP_CATEGORY).when(tripCategorizerService).getTripCategory(climbingRockMock, USER_LOCATION);

        List<ClimbingRock> resultList =
                climbingRockFilterService.getClimbingRocksWithTripConditions(PARTICIPANT_EXPERIENCE_BEGINNER, TRIP_CATEGORY, USER_LOCATION);
        assertEquals(climbingRockListMock, resultList);
    }

    @Test
    void getClimbingRocksWithParticipantExperienceAdvanced() {
        doReturn(climbingRockListMock).when(climbingRockRepository).getClimbingRocksForAdvancedParticipants();
        doReturn(TRIP_CATEGORY).when(tripCategorizerService).getTripCategory(climbingRockMock, USER_LOCATION);

        List<ClimbingRock> resultList =
                climbingRockFilterService.getClimbingRocksWithTripConditions(PARTICIPANT_EXPERIENCE_ADVANCED, TRIP_CATEGORY, USER_LOCATION);
        assertEquals(climbingRockListMock, resultList);
    }

    @Test
    void getClimbingRocksWithParticipantExperienceProfessional() {
        doReturn(climbingRockListMock).when(climbingRockRepository).getClimbingRocksForProfessionalParticipants();
        doReturn(TRIP_CATEGORY).when(tripCategorizerService).getTripCategory(climbingRockMock, USER_LOCATION);

        List<ClimbingRock> resultList =
                climbingRockFilterService.getClimbingRocksWithTripConditions(PARTICIPANT_EXPERIENCE_PROFESSIONAL, TRIP_CATEGORY, USER_LOCATION);
        assertEquals(climbingRockListMock, resultList);
    }
}
