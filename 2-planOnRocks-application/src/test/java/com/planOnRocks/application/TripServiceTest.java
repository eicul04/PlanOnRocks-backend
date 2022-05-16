package com.planOnRocks.application;

import com.planOnRocks.application.trip.TripService;
import com.planOnRocks.domain.climbingRock.*;
import com.planOnRocks.domain.trip.ParticipantExperience;
import com.planOnRocks.domain.trip.Trip;
import com.planOnRocks.domain.trip.TripRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private final TripCategory TRIP_CATEGORY = TripCategory.WEEKEND_TRIP;
    private final Date START_DATE = new GregorianCalendar(2023, Calendar.MAY, 20).getTime();
    private final Date END_DATE = new GregorianCalendar(2023, Calendar.MAY, 22).getTime();;

    @Test
    void saveTrip() {
        Trip tripToSave = new Trip(START_DATE, END_DATE, PARTICIPANT_EXPERIENCE, TRIP_CATEGORY);

        doReturn(tripToSave).when(this.tripRepository).save(tripToSave);
        Trip savedTrip = this.tripService.createTrip(tripToSave);

        verify(this.tripRepository, times(1)).save(any(Trip.class));
        assertEquals(tripToSave, savedTrip);
    }

}
