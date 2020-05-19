package de.slotmachine.rest;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.slotmachine.rest.config.Config; 
 
@SpringBootApplication
public class Main {
 
    public static void main(String[] args) {
    	Config.init();
        SpringApplication.run(Main.class, args);
    }
}