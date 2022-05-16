package com.planOnRocks.domain.climbingRock.valueObjects;
import java.io.Serializable;

public final class Location implements Serializable {

    private static final long serialVersionUID = 1343658701223119809L;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private final double latitude;
    private final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

}
