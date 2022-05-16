package com.planOnRocks.domain.climbingRock.valueObjects;

import com.planOnRocks.domain.climbingRock.enums.DistanceUnit;

public final class Distance {

    private final double value;
    private final DistanceUnit unit;

    public Distance(double value, DistanceUnit unit) {
        this.value = value;
        this.unit = DistanceUnit.KILOMETER;
    }

    public double getValue() {
        return value;
    }

    public DistanceUnit getUnit() {
        return unit;
    }

}
