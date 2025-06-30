package com.sandeep.driver_location_producer.service;

import com.sandeep.driver_location_producer.model.DriverLocation;

public interface LocationPublisherService {

    void publishLocation(DriverLocation driverLocation);
}
