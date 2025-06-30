package com.sandeep.driver_location_producer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeep.driver_location_producer.model.DriverLocation;
import com.sandeep.driver_location_producer.service.LocationPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationPublisherServiceImpl implements LocationPublisherService {

    @Value("${kafka.topic.driver-location}")
    private String driverLocationTopic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void publishLocation(DriverLocation driverLocation) {
        try {
            String key = driverLocation.getDriverId();
            String value = objectMapper.writeValueAsString(driverLocation);
            kafkaTemplate.send(driverLocationTopic, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
