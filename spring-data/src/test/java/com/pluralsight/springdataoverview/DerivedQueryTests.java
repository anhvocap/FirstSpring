package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import com.pluralsight.springdataoverview.repository.FlightRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class DerivedQueryTests {
    @Autowired
    private FlightRepository flightRepository;

    @Before("")
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldFindFlightsFromLondon() {
        final Flight flight1 = createFlight("London");
        final Flight flight2 = createFlight("London");
        final Flight flight3 = createFlight("New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsToLondon = flightRepository.findByOrigin("London");
        assert(flightsToLondon).size()==2;
        assert(flightsToLondon.get(0)).equals(flight1);
        assert(flightsToLondon.get(1)).equals(flight2);
    }

    @Test
    public void shouldFindFlightsFromLondonToNewYork() {
        final Flight flight1 = createFlight("London", "New York");
        final Flight flight2 = createFlight("London", "Paris");
        final Flight flight3 = createFlight("New York", "London");
        final Flight flight4 = createFlight("London", "Mumbai");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);

        List<Flight> flightsToLondon = flightRepository.findByOriginAndDestination("London", "Mumbai");
        assert(flightsToLondon).stream().count() == 1;
        assert(flightsToLondon.get(0)).getOrigin().equals("London");
        assert(flightsToLondon.get(0)).getDestination().equals("Mumbai");
        assert(flightsToLondon.get(0)).equals(flight4);
    }

    @Test
    public void shouldFindFlightFromLondonOrParis() {
        final Flight flight1 = createFlight("London", "New York");
        final Flight flight2 = createFlight("Paris", "New York");
        final Flight flight3 = createFlight("Madrid", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> londonOrMadrid = flightRepository.findByOriginIn("London", "Paris");

        assert(londonOrMadrid).stream().count() == 2;
        assert(londonOrMadrid.get(0)).equals(flight1);
        assert(londonOrMadrid.get(1)).equals(flight2);
    }

    @Test
    public void shouldFindFlightFromIgnoringCase() {
        final Flight flight1 = createFlight("LONDON", "New York");
        final Flight flight2 = createFlight("Paris", "New York");
        final Flight flight3 = createFlight("Madrid", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> londonOrMadrid = flightRepository.findByOriginIgnoreCase("london");

        assert (londonOrMadrid).stream().count() == 1;
        assert (londonOrMadrid.get(0)).equals(flight1);
    }

    private Flight createFlight(String origin) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination("Madrid");
        flight.setScheduledAt(LocalDateTime.parse("2011-12-15T12:12:00"));
        return flight;
    }

    private Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduledAt(LocalDateTime.parse("2011-12-15T12:12:00"));
        return flight;
    }
}
