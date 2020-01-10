package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFlightRepository implements FlightRepository {
    @Override
    public List<Flight> getFlights() {

        Station stationWarsaw = new Station("Warsaw");
        Station stationKrakow = new Station("Krakow");
        Station stationGdansk = new Station("Gdansk");
        Station stationAmsterdam = new Station("Amsterdam");
        Station stationParis = new Station("Paris");
        Station stationLondon = new Station("London");
        Station stationBarcelona = new Station("Barcelona");
        Station stationBerlin = new Station("Berlin");

        List<Station> warsaw_Krakow_Gdansk = new ArrayList<>();
        List<Station> gdansk_Krakow_Warsaw = new ArrayList<>();
        List<Station> krakow_London_Barcelona = new ArrayList<>();
        List<Station> barcelona_London_Krakow = new ArrayList<>();
        List<Station> krakow_Berlin_Barcelona = new ArrayList<>();
        List<Station> barcelona_Berlin_Krakow = new ArrayList<>();
        List<Station> krakow_Amsterdam_Paris_Barcelona = new ArrayList<>();
        List<Station> barcelona_Paris_Amsterdam_Krakow = new ArrayList<>();

        warsaw_Krakow_Gdansk.add(stationWarsaw);
        warsaw_Krakow_Gdansk.add(stationKrakow);
        warsaw_Krakow_Gdansk.add(stationGdansk);

        gdansk_Krakow_Warsaw.add(stationGdansk);
        gdansk_Krakow_Warsaw.add(stationKrakow);
        gdansk_Krakow_Warsaw.add(stationWarsaw);

        krakow_London_Barcelona.add(stationKrakow);
        krakow_London_Barcelona.add(stationLondon);
        krakow_London_Barcelona.add(stationBarcelona);

        barcelona_London_Krakow.add(stationBarcelona);
        barcelona_London_Krakow.add(stationLondon);
        barcelona_London_Krakow.add(stationKrakow);

        krakow_Berlin_Barcelona.add(stationKrakow);
        krakow_Berlin_Barcelona.add(stationBerlin);
        krakow_Berlin_Barcelona.add(stationBarcelona);

        barcelona_Berlin_Krakow.add(stationBarcelona);
        barcelona_Berlin_Krakow.add(stationBerlin);
        barcelona_Berlin_Krakow.add(stationKrakow);

        krakow_Amsterdam_Paris_Barcelona.add(stationKrakow);
        krakow_Amsterdam_Paris_Barcelona.add(stationAmsterdam);
        krakow_Amsterdam_Paris_Barcelona.add(stationParis);
        krakow_Amsterdam_Paris_Barcelona.add(stationBarcelona);

        barcelona_Paris_Amsterdam_Krakow.add(stationBarcelona);
        barcelona_Paris_Amsterdam_Krakow.add(stationParis);
        barcelona_Paris_Amsterdam_Krakow.add(stationAmsterdam);
        barcelona_Paris_Amsterdam_Krakow.add(stationKrakow);

        Flight flight1_Warsaw_Krakow_Gdansk = new Flight(warsaw_Krakow_Gdansk);
        Flight flight2_Gdansk_Krakow_Warsaw = new Flight(gdansk_Krakow_Warsaw);
        Flight flight3_Krakow_London_Barcelona = new Flight(krakow_London_Barcelona);
        Flight flight4_Barcelona_London_Krakow = new Flight(barcelona_London_Krakow);
        Flight flight5_Krakow_Berlin_Barcelona = new Flight(krakow_Berlin_Barcelona);
        Flight flight6_Barcelona_Berlin_Krakow = new Flight(barcelona_Berlin_Krakow);
        Flight flight7_Krakow_Amsterdam_Paris_Barcelona = new Flight(krakow_Amsterdam_Paris_Barcelona);
        Flight flight8_Barcelona_Paris_Amsterdam_Krakow = new Flight(barcelona_Paris_Amsterdam_Krakow);

        List<Flight> flights = new ArrayList<>();

        flights.add(flight1_Warsaw_Krakow_Gdansk);
        flights.add(flight2_Gdansk_Krakow_Warsaw);
        flights.add(flight3_Krakow_London_Barcelona);
        flights.add(flight4_Barcelona_London_Krakow);
        flights.add(flight5_Krakow_Berlin_Barcelona);
        flights.add(flight6_Barcelona_Berlin_Krakow);
        flights.add(flight7_Krakow_Amsterdam_Paris_Barcelona);
        flights.add(flight8_Barcelona_Paris_Amsterdam_Krakow);

        return flights;
    }
}
