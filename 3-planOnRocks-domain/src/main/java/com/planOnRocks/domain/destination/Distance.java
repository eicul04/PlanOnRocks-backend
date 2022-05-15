package com.planOnRocks.domain.destination;

enum DistanceUnit {
    METER, KILOMETER
}

public final class Distance {

    public double getValue() {
        return value;
    }

    public DistanceUnit getUnit() {
        return unit;
    }

    private final double value;
    private final DistanceUnit unit;

    public Distance(double value, DistanceUnit unit) {
        this.value = value;
        this.unit = DistanceUnit.KILOMETER;
    }

}
