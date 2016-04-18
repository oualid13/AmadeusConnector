/**
 * 
 */
package com.tripdeal.util;

import java.util.Map;

/**
 * @author sundaramtiwari
 *
 */
public class TripUtil {

    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";
    private static final String QUESTION_MARK = "?";
    private static final String API_KEY = "E4Grt5b3kV5MFLHu61mnZKsEvMCfC4cn";

    public static String getFullURL (String url, Map<String, String> queryMap) {
        StringBuilder fullUrl = new StringBuilder(url);
        
        if (queryMap != null && !queryMap.isEmpty()) {
            fullUrl.append(QUESTION_MARK);

            for (String key : queryMap.keySet()) {
                fullUrl.append(key).append(EQUAL).append(queryMap.get(key)).append(AMPERSAND);
            }
            
            fullUrl.append("apikey=").append(API_KEY);
        }
        
        return fullUrl.toString();
    }
}
