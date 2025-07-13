package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public void displayCountry() {

			LOGGER.info("START - displayCountries()");

			ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

			List<Country> countryList = context.getBean("countryList", List.class);
			LOGGER.debug("Country List: {}", countryList);

			LOGGER.info("END - displayCountries()");


	}


	public void displayDate(){
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        Date date = null;
        try {
            date = format.parse("10/07/2025");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
		LOGGER.debug("Formatted Date: {}", date);
		LOGGER.info("END");
	}
	public static void main(String[] args) {

		SpringApplication.run(SpringLearnApplication.class, args);
		System.out.println("Hello Welcome to learn spring..");
		SpringLearnApplication app = new SpringLearnApplication();
		app.displayDate();
		app.displayCountry();
	}

}
