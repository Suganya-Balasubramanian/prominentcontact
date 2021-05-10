package com.sample.pc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProminentContactTaskApplication {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProminentContactTaskApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProminentContactTaskApplication.class, args);
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		
		
	}

}
