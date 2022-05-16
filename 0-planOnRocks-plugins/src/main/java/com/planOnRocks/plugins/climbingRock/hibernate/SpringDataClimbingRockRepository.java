package com.planOnRocks.plugins.climbingRock.hibernate;

import com.planOnRocks.domain.climbingRock.ClimbingRock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataClimbingRockRepository extends JpaRepository<ClimbingRock, Long> {

    @Query(value = "SELECT * FROM CLIMBING_ROCK where DIFFICULTY = 'EASY' AND BOLTING = 'GOOD' OR BOLTING = 'VERY_GOOD'",
            nativeQuery = true)
    List<ClimbingRock> getClimbingRocksForBeginnerParticipants();

    @Query(value = "SELECT * FROM CLIMBING_ROCK where DIFFICULTY = 'EASY' OR DIFFICULTY = 'MEDIUM' AND BOLTING = 'OK' OR BOLTING = 'GOOD' OR BOLTING = 'VERY_GOOD'",
            nativeQuery = true)
    List<ClimbingRock> getClimbingRocksForAdvancedParticipants();

    @Query(value = "SELECT * FROM CLIMBING_ROCK where DIFFICULTY = 'EASY' OR DIFFICULTY = 'MEDIUM' OR DIFFICULTY = 'HARD' AND BOLTING = 'BAD' OR BOLTING = 'OK' OR BOLTING = 'GOOD' OR BOLTING = 'VERY_GOOD'",
            nativeQuery = true)
    List<ClimbingRock> getClimbingRocksForProfessionalParticipants();

    List<ClimbingRock> findAll();
}
