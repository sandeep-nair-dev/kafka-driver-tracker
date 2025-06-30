package com.sandeep.driver_location_producer.controller;

import com.sandeep.driver_location_producer.model.DriverLocation;
import com.sandeep.driver_location_producer.service.LocationPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LocationController {

    @Autowired
    private LocationPublisherService locationPublisherService;

    @PostMapping("/updateLocation")
    private String updateLocation(@RequestBody DriverLocation driverLocation){
        locationPublisherService.publishLocation(driverLocation);
        return "Driver location update published successfully";
    }
}
