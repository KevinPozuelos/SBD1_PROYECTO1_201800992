package com.example.SBD1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sbd1Application {
	private static Logger logger = LoggerFactory.getLogger(Sbd1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Sbd1Application.class, args);

		logger.debug("YA SALIO BASES");
	}

	}



