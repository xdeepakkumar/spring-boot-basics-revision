package com.dailyCodeBuffer.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Controller;

@Controller
@Endpoint(id = "features")
public class FeatureEndpoints {

	private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();
	
	
	private static class Feature{
		private boolean isEnabled;
	}
	
}
