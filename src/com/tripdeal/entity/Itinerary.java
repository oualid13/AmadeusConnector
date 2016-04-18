package com.tripdeal.entity;

public class Itinerary {

    private String departs_at;
    private String arrives_at;
    private Origin origin;
    private Destination destination;
    private String marketing_airline;
    private String operating_airline;
    private String flight_number;
    private String aircraft;
    private BookingInfo bookingInfo;

    public String getDeparts_at() {
        return departs_at;
    }

    public void setDeparts_at(String departs_at) {
        this.departs_at = departs_at;
    }

    public String getArrives_at() {
        return arrives_at;
    }

    public void setArrives_at(String arrives_at) {
        this.arrives_at = arrives_at;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getMarketing_airline() {
        return marketing_airline;
    }

    public void setMarketing_airline(String marketing_airline) {
        this.marketing_airline = marketing_airline;
    }

    public String getOperating_airline() {
        return operating_airline;
    }

    public void setOperating_airline(String operating_airline) {
        this.operating_airline = operating_airline;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    @Override
    public String toString() {
        return "Itinerary [" + (departs_at != null ? "departs_at=" + departs_at + ", " : "") + (arrives_at != null ? "arrives_at=" + arrives_at + ", " : "")
                + (origin != null ? "origin=" + origin + ", " : "") + (destination != null ? "destination=" + destination + ", " : "")
                + (marketing_airline != null ? "marketing_airline=" + marketing_airline + ", " : "") + (operating_airline != null ? "operating_airline=" + operating_airline + ", " : "")
                + (flight_number != null ? "flight_number=" + flight_number + ", " : "") + (aircraft != null ? "aircraft=" + aircraft + ", " : "")
                + (bookingInfo != null ? "bookingInfo=" + bookingInfo : "") + "]";
    }
}

class Origin {
    private String airport;
    private String terminal;

    public Origin() {
        super();
    }

    public Origin(String airport, String terminal) {
        super();
        this.airport = airport;
        this.terminal = terminal;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return "Origin [" + (airport != null ? "airport=" + airport + ", " : "") + (terminal != null ? "terminal=" + terminal : "") + "]";
    }

}

class Destination {
    private String airport;
    private String terminal;

    public Destination() {
        super();
    }

    public Destination(String airport, String terminal) {
        super();
        this.airport = airport;
        this.terminal = terminal;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return "Destination [" + (airport != null ? "airport=" + airport + ", " : "") + (terminal != null ? "terminal=" + terminal : "") + "]";
    }
}

class BookingInfo {
    private String travel_class;
    private String booking_code;
    private String seats_remaining;
    
    public BookingInfo() {
        super();
    }
    public BookingInfo(String travel_class, String booking_code, String seats_remaining) {
        super();
        this.travel_class = travel_class;
        this.booking_code = booking_code;
        this.seats_remaining = seats_remaining;
    }
    public String getTravel_class() {
        return travel_class;
    }
    public void setTravel_class(String travel_class) {
        this.travel_class = travel_class;
    }
    public String getBooking_code() {
        return booking_code;
    }
    public void setBooking_code(String booking_code) {
        this.booking_code = booking_code;
    }
    public String getSeats_remaining() {
        return seats_remaining;
    }
    public void setSeats_remaining(String seats_remaining) {
        this.seats_remaining = seats_remaining;
    }
    @Override
    public String toString() {
        return "BookingInfo [" + (travel_class != null ? "travel_class=" + travel_class + ", " : "") + (booking_code != null ? "booking_code=" + booking_code + ", " : "")
                + (seats_remaining != null ? "seats_remaining=" + seats_remaining : "") + "]";
    }
}
