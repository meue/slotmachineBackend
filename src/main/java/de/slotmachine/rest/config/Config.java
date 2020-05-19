package de.slotmachine.rest.config;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {
	public static ReelsConfig reelsConfig;
	public static PaylinesConfig paylinesConfig;
	public static PaytableConfig paytableConfig;
	
	public static void init() {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
        	Config.reelsConfig = objectMapper.readValue(new File("config/reelsConfig.json"), ReelsConfig.class);
	    	Config.paylinesConfig = objectMapper.readValue(new File("config/paylinesConfig.json"), PaylinesConfig.class);
	    	Config.paytableConfig = objectMapper.readValue(new File("config/paytableConfig.json"), PaytableConfig.class);
		} catch (Exception e) {
			System.out.println("Error reading configFiles");
			e.printStackTrace();
		}
	}
}
