package com.planOnRocks.plugins.trip;

import com.planOnRocks.domain.trip.Trip;
import org.springframework.data.repository.CrudRepository;

public interface SpringDataTripRepository extends CrudRepository<Trip, Long> {
}
