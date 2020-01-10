package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightRepository getFlightRepository() {
        return flightRepository;
    }

    public List<Flight> from(Station station) {
        return this.flightRepository.getFlights().stream()
                .filter(flight -> flight.getFirstStation().equals(station))
                .collect(Collectors.toList());
    }

    public List<Flight> to(Station station) {
        return this.flightRepository.getFlights().stream()
                .filter(flight -> flight.getLastStation().equals(station))
                .collect(Collectors.toList());
    }

    public List<Flight> through(Station station) {
        return this.flightRepository.getFlights().stream()
                .filter(flight -> flight.getStations().contains(station))
                .filter(flight -> !flight.getFirstStation().equals(station))
                .filter(flight -> !flight.getLastStation().equals(station))
                .collect(Collectors.toList());
    }
}
