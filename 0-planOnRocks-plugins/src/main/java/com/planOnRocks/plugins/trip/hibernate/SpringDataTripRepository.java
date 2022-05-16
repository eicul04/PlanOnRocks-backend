package com.planOnRocks.plugins.trip.hibernate;

import com.planOnRocks.domain.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTripRepository extends JpaRepository<Trip, Long> {
}
