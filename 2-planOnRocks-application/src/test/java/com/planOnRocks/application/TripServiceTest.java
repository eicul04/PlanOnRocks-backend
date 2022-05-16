package com.planOnRocks.application;

import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.climbingRock.enums.TripCategory;
import com.planOnRocks.domain.trip.enums.ParticipantExperience;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TripServiceTest {

    @Mock
    TripRepository tripRepository;

    @InjectMocks
    TripService tripService;

    private static final ParticipantExperience PARTICIPANT_EXPERIENCE = ParticipantExperience.BEGINNER;
    private final TripCategory TRIP_CATEGORY = TripCategory.DAY_TRIP;
    private final LocalDate START_DATE = LocalDate.now();
    private final LocalDate END_DATE = LocalDate.now();

    @Test
    void saveTrip() {
        Trip tripToSave = new Trip(START_DATE, END_DATE, PARTICIPANT_EXPERIENCE, TRIP_CATEGORY);

        doReturn(tripToSave).when(this.tripRepository).save(tripToSave);
        Trip savedTrip = this.tripService.createTrip(tripToSave);

        verify(this.tripRepository, times(1)).save(any(Trip.class));
        assertEquals(tripToSave, savedTrip);
    }

}
