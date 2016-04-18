package com.tripdeal.main;

import java.util.List;

import com.tripdeal.entity.Flight;
import com.tripdeal.entity.SearchCriteria;
import com.tripdeal.service.SerachServiceImpl;

public class GetLowestFair {

    public static void main(String[] args) {
        String origin = "BOS";
        String destination = "LON";
        String departure = "2016-06-25";

        SearchCriteria sc = new SearchCriteria();
        sc.setOrigin(origin);
        sc.setDestination(destination);
        sc.setDepartDate(departure);

        SerachServiceImpl ssi = new SerachServiceImpl();
        List<Flight> lowestFair = ssi.getLowestFair(sc);
        
        for (Flight flight : lowestFair) {
            System.out.println(flight);
        }
    }

}
