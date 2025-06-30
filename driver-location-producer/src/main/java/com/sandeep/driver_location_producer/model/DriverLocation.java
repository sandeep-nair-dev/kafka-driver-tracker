package com.sandeep.driver_location_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//@Data
//@AllArgsConstructor
public class DriverLocation {
    private String driverId;
    private String longitude;
    private String latitude;
    private String timestamp;

    public DriverLocation(String driverId, String longitude, String latitude, String timestamp) {
        this.driverId = driverId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
