package com.planOnRocks.application.climbingRock;

import com.planOnRocks.domain.climbingRock.*;
import com.planOnRocks.domain.trip.ParticipantExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimbingRockFilterService implements ClimbingRockFilterDomainService {

    @Autowired
    public ClimbingRockFilterService(ClimbingRockRepository climbingRockRepository, TripCategorizerService tripCategorizer) {
        this.climbingRockRepository = climbingRockRepository;
        this.tripCategorizer = tripCategorizer;
    }

    private final ClimbingRockRepository climbingRockRepository;
    private final TripCategorizerService tripCategorizer;


    public List<ClimbingRock> getClimbingRocksWithTripConditions(ParticipantExperience participantExperience, TripCategory tripCategory, Location userLocation){
        List<ClimbingRock> filteredClimbingRocksByParticipantExperience = getClimbingRocksFilteredByParticipantExperience(participantExperience);
        return getClimbingRocksFilteredByTripCategory(tripCategory, userLocation, filteredClimbingRocksByParticipantExperience);
    }

    private List<ClimbingRock> getClimbingRocksFilteredByParticipantExperience(ParticipantExperience participantExperience) {
        if(participantExperience == ParticipantExperience.BEGINNER) {
            return climbingRockRepository.getClimbingRocksForBeginnerParticipants();
        }
        if(participantExperience == ParticipantExperience.ADVANCED) {
            return climbingRockRepository.getClimbingRocksForAdvancedParticipants();
        }
        if(participantExperience == ParticipantExperience.PROFESSIONAL) {
            return climbingRockRepository.getClimbingRocksForProfessionalParticipants();
        }
        return new ArrayList<>();
    }

    private List<ClimbingRock> getClimbingRocksFilteredByTripCategory(TripCategory tripCategory, Location userLocation, List<ClimbingRock> filteredClimbingRocksByParticipantExperience) {
        List<ClimbingRock> climbingRocksFilteredByTripCategory = new ArrayList<>();

        for(ClimbingRock climbingRock: filteredClimbingRocksByParticipantExperience) {
            if(tripCategorizer.getTripCategory(climbingRock, userLocation) == tripCategory) {
                climbingRocksFilteredByTripCategory.add(climbingRock);
            }
        }
        return climbingRocksFilteredByTripCategory;
    }
}
