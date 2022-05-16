package com.planOnRocks.domain.climbingRock.valueObjects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocationConverter implements AttributeConverter<Location, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(Location location) {
        return location.getLatitude() + DELIMITER + location.getLongitude();
    }

    @Override
    public Location convertToEntityAttribute(String dbLocation) {
        String[] locationCoordinates = dbLocation.split(DELIMITER);
        return new Location(Double.parseDouble(locationCoordinates[0]), Double.parseDouble(locationCoordinates[1]));
    }
}
