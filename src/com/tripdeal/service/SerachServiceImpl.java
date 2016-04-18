/**
 * 
 */
package com.tripdeal.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.tripdeal.entity.Fare;
import com.tripdeal.entity.Flight;
import com.tripdeal.entity.Itinerary;
import com.tripdeal.entity.SearchCriteria;
import com.tripdeal.util.JsonUtil;
import com.tripdeal.util.RestUtil;
import com.tripdeal.util.TripUtil;

/**
 * @author sundaramtiwari
 *
 */
public class SerachServiceImpl {

    private static final String NEW_LINE = "\n";
    private static final String COMMA = ", ";
    private static final String getLowestURL = "https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search";
    private static final String fileName = "/home/sundaramtiwari/Documents/Work/tripDeal.txt";

    @SuppressWarnings("unchecked")
    public List<Flight> getLowestFair(SearchCriteria sc) {
        List<Flight> flights = new ArrayList<Flight>();
        Map<String, String> queryMap = getQueryMap(sc);
        String url = TripUtil.getFullURL(getLowestURL, queryMap);

        String response = RestUtil.get(url);

        FileWriter updateFileWriter = getFileWriter(fileName);
        BufferedWriter updateBufWriter = new BufferedWriter(updateFileWriter);

        try {
            ObjectMapper objectMapper = getObjectMapper();
            Map<String, Object> responseMap = (Map<String, Object>) objectMapper.readValue(response, Map.class);
            if (responseMap != null && !responseMap.isEmpty()) {
                List<Map<String, Object>> listOfResults = (List<Map<String, Object>>) responseMap.get("results");
                if (listOfResults != null & !listOfResults.isEmpty()) {
                    for (Map<String, Object> result : listOfResults) {
                        List<Map<String, Map<String, List<Itinerary>>>> list = (List<Map<String, Map<String, List<Itinerary>>>>) result.get("itineraries");
                        Map<String, List<Itinerary>> outboundMap = list.get(0).get("outbound");
                        List<Itinerary> flightList = outboundMap.get("flights");
                        
                        Fare fare = (Fare) result.get("fare");

                        Flight flight = new Flight(flightList, fare);
                        flights.add(flight);
                        writeToUpdateFile(updateBufWriter, flightList, fare);
                    }
                }
            }
            updateBufWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                updateBufWriter.close();

                updateFileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return flights;
    }

    private void writeToUpdateFile(BufferedWriter updateBufWriter, List<Itinerary> flightList, Fare fare) {
        for (Itinerary iti : flightList) {
            String str = iti.getMarketing_airline() + COMMA + iti.getFlight_number() + COMMA + iti.getOrigin() + COMMA + iti.getDestination() + COMMA + iti.getDeparts_at() + COMMA
                    + iti.getArrives_at() + COMMA + iti.getBookingInfo() + NEW_LINE;
            updateBufWriter.write(str);
        }

    }

    private Map<String, String> getQueryMap(SearchCriteria sc) {
        Map<String, String> queryMap = new HashMap<String, String>();
        queryMap.put("origin", sc.getOrigin());
        queryMap.put("destination", sc.getDestination());
        queryMap.put("departure_date", sc.getDepartDate());

        return queryMap;
    }

    private static FileWriter getFileWriter(String fileName) {
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            if (!file.exists()) {

                file.createNewFile();
                fw = new FileWriter(file.getAbsoluteFile());

            } else {
                fw = new FileWriter(file.getAbsoluteFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fw == null)
            System.exit(0);
        return fw;
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
        return objectMapper;
    }
}
