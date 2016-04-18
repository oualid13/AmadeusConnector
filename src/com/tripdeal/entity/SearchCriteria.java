package com.tripdeal.entity;

import java.util.Date;

/**
 * @author sundaramtiwari
 *
 */
public class SearchCriteria {

    private String origin;
    private String destination;
    private String departDate;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

}
