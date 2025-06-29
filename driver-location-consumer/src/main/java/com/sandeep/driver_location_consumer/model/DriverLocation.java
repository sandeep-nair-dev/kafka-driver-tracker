package com.sandeep.driver_location_consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DriverLocation {
    private String driverId;
    private String longitude;
    private String latitude;
    private String timestamp;
}
