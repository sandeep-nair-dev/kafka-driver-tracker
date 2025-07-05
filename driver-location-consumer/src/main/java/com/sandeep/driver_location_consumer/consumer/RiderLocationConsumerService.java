package com.sandeep.driver_location_consumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeep.driver_location_consumer.model.DriverLocation;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RiderLocationConsumerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${spring.kafka.consumer.topic.driver-location}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(ConsumerRecord<String, String> record) {
        try {
            String key = record.key();
            String value = record.value();

            DriverLocation driverLocation = objectMapper.readValue(value, DriverLocation.class);

            System.out.println("📡 Location update received for driver " + driverLocation.getDriverId());
            System.out.println("   Coordinates: " + driverLocation.getLatitude() + ", " + driverLocation.getLongitude());
            System.out.println("   Time: " + driverLocation.getTimestamp());

            notifyRider(driverLocation);
            notifySharedUsers(driverLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notifyRider(DriverLocation location) {
        System.out.println("📨 Rider notified: Driver " + location.getDriverId() + " location updated.");
    }

    private void notifySharedUsers(DriverLocation location) {
        System.out.println("📨 Shared users notified: Driver " + location.getDriverId() + " location updated.");
    }
}
