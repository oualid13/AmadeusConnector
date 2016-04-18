/**
 * 
 */
package com.tripdeal.entity;

import java.util.List;

/**
 * @author sundaramtiwari
 *
 */
public class Flight {

    List<Itinerary> flightList;
    Fare fare;
    public Flight() {
    }
    public Flight(List<Itinerary> flightList, Fare fare) {
        this.flightList = flightList;
        this.fare = fare;
    }
    public List<Itinerary> getFlightList() {
        return flightList;
    }
    public void setFlightList(List<Itinerary> flightList) {
        this.flightList = flightList;
    }
    public Fare getFare() {
        return fare;
    }
    public void setFare(Fare fare) {
        this.fare = fare;
    }
    @Override
    public String toString() {
        return "Flight [" + (flightList != null ? "flightList=" + flightList + ", " : "") + (fare != null ? "fare=" + fare : "") + "]";
    }    
}
