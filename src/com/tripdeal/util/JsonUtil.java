package com.tripdeal.util;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JsonUtil {

	private static ObjectMapper mapper;

	public static ObjectMapper getObjectMapper() {
		synchronized (mapper) {
			if (mapper == null) {
				mapper = new ObjectMapper();
				mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
			}
		}

		return mapper;
	}
}
