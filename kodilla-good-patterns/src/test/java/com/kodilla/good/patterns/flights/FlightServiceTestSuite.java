package com.kodilla.good.patterns.flights;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FlightServiceTestSuite {

    @Test
    public void from() {
        //Given
        FlightRepository flightRepository = new InMemoryFlightRepository();
        FlightService flightService = new FlightService(flightRepository);
        Station krakow = new Station("Krakow");
        Station warsaw = new Station("Warsaw");
        Station barcelona = new Station("Barcelona");
        Station mexico = new Station("Mexico");

        //When
        List<Flight> actualStation = flightService.from(krakow);
        List<Flight> actualStation2 = flightService.from(warsaw);
        List<Flight> actualStation3 = flightService.from(barcelona);
        List<Flight> actualStation4 = flightService.from(mexico);

        //Then
        Assert.assertEquals(3, actualStation.size());
        Assert.assertEquals(1, actualStation2.size());
        Assert.assertEquals(3, actualStation3.size());
        Assert.assertEquals(0, actualStation4.size());
    }

    @Test
    public void to() {
        //Given
        FlightRepository flightRepository = new InMemoryFlightRepository();
        FlightService flightService = new FlightService(flightRepository);
        Station krakow = new Station("Krakow");
        Station warsaw = new Station("Warsaw");
        Station barcelona = new Station("Barcelona");
        Station mexico = new Station("Mexico");

        //When
        List<Flight> actualStation = flightService.to(krakow);
        List<Flight> actualStation2 = flightService.to(warsaw);
        List<Flight> actualStation3 = flightService.to(barcelona);
        List<Flight> actualStation4 = flightService.to(mexico);

        //Then
        Assert.assertEquals(3, actualStation.size());
        Assert.assertEquals(1, actualStation2.size());
        Assert.assertEquals(3, actualStation3.size());
        Assert.assertEquals(0, actualStation4.size());
    }

    @Test
    public void through() {
        //Given
        FlightRepository flightRepository = new InMemoryFlightRepository();
        FlightService flightService = new FlightService(flightRepository);
        Station london = new Station("London");
        Station paris = new Station("Paris");
        Station mexico = new Station("Mexico");

        //When
        List<Flight> actualStation = flightService.through(london);
        List<Flight> actualStation2 = flightService.through(paris);
        List<Flight> actualStation3 = flightService.through(mexico);

        //Then
        Assert.assertEquals(2, actualStation.size());
        Assert.assertEquals(2, actualStation2.size());
        Assert.assertEquals(0, actualStation3.size());
    }
}