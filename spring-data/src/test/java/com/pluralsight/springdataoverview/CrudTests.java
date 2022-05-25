package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import com.pluralsight.springdataoverview.repository.FlightRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
public class CrudTests {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void shouldPerformCRUDOperations() {
        final Flight flight = new Flight();
        flight.setOrigin("London");
        flight.setDestination("Dubai");
        flight.setScheduledAt(LocalDateTime.parse("2022-12-12T12:12:00"));

        flightRepository.save(flight);

        Iterable<Flight> flights = flightRepository.findAll();
        assert(flights).iterator().next().equals(flight);
        System.out.println("flights:" + flights.toString());
    }
}
