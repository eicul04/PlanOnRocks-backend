package com.planOnRocks.plugins.climbingRock.hibernate;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import com.planOnRocks.domain.climbingRock.ClimbingRockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClimbingRockRepositoryBridge implements ClimbingRockRepository {

    private final SpringDataClimbingRockRepository springDataClimbingRockRepository;

    @Autowired
    public ClimbingRockRepositoryBridge(SpringDataClimbingRockRepository springDataClimbingRockRepository) {
        this.springDataClimbingRockRepository = springDataClimbingRockRepository;
    }

    @Override
    public ClimbingRock save(ClimbingRock climbingRock) {
        return this.springDataClimbingRockRepository.save(climbingRock);
    }

    @Override
    public List<ClimbingRock> getClimbingRocksForBeginnerParticipants() {
        return this.springDataClimbingRockRepository.getClimbingRocksForBeginnerParticipants();
    }

    @Override
    public List<ClimbingRock> getClimbingRocksForAdvancedParticipants() {
        return this.springDataClimbingRockRepository.getClimbingRocksForAdvancedParticipants();
    }

    @Override
    public List<ClimbingRock> getClimbingRocksForProfessionalParticipants() {
        return this.springDataClimbingRockRepository.getClimbingRocksForProfessionalParticipants();
    }

    @Override
    public List<ClimbingRock> getClimbingRocks() {
        return this.springDataClimbingRockRepository.findAll();
    }

    @Override
    public ClimbingRock getClimbingRockById(Long climbingRockId) {
        return this.springDataClimbingRockRepository.getById(climbingRockId);
    }
}
