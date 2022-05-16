package com.planOnRocks.domain.climbingRock;

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
