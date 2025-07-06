package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
@EntityScan("com.cognizant.orm_learn.model")
@EnableJpaRepositories("com.cognizant.orm_learn.repository")
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testAddCountry();
        testGetAllCountries();
        testFindCountryById();
        testDeleteCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start - testAddCountry");
        Country country = new Country();
        country.setCode("JP");
        country.setName("Japan");
        countryService.addCountry(country);
        LOGGER.info("End - testAddCountry");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(c -> LOGGER.debug("Country: {}", c));
        LOGGER.info("End - testGetAllCountries");
    }

    private static void testFindCountryById() {
        LOGGER.info("Start - testFindCountryById");
        Country country = countryService.findCountryById("IN");
        LOGGER.debug("Found: {}", country);
        LOGGER.info("End - testFindCountryById");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start - testDeleteCountry");
        countryService.deleteCountry("JP");
        LOGGER.info("End - testDeleteCountry");
    }
	private static void getAllCountriesTest() {
    LOGGER.info("Start");
    try {
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
    } catch (CountryNotFoundException e) {
        LOGGER.error("Exception: {}", e.getMessage());
    }
    LOGGER.info("End");
}


}
