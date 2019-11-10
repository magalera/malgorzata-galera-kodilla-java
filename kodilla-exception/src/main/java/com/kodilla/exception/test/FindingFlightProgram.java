package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindingFlightProgram {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flights = new HashMap<>();
        flights.put("Warsaw", true);
        flights.put("Krakow", false);
        flights.put("Barcelona", false);

        Boolean canFly = flights.get(flight.getArrivalAirport());

        if (Boolean.TRUE.equals(canFly)) {
            System.out.println("Flight to " + flight.getArrivalAirport() + " is possible");
        } else {
            throw new RouteNotFoundException(flight);
        }
    }

    public static void main(String[] args) {
        FindingFlightProgram findingFlightProgram = new FindingFlightProgram();
        try {
            findingFlightProgram.findFlight(new Flight("Greece", "Warsaw"));
            findingFlightProgram.findFlight(new Flight("Greece", "Krakow"));
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        }
    }
}
