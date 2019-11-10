package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException (final Flight flight){
        super("Flight to " + flight.getArrivalAirport() + " is not possible");
    }
}
