package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Objects;

public class Flight {
    private List<Station> stations;

    public Flight(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }

    public Station getFirstStation() {
        return this.stations.get(0);
    }

    public Station getLastStation() {
        return this.stations.get(this.stations.size()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getStations().equals(flight.getStations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStations());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "stations=" + stations +
                '}';
    }
}
