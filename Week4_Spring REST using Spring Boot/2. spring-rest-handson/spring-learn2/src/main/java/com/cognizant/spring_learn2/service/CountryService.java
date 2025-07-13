package com.cognizant.spring_learn2.service;


import com.cognizant.spring_learn2.model.Country;
import com.cognizant.spring_learn2.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private ApplicationContext context;

    public Country getCountry(String code) throws CountryNotFoundException {
        List<Country> countries = (List<Country>) context.getBean("countryList");
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }

    public List<Country> getAllCountries() {
        return (List<Country>) context.getBean("countryList");
    }
}
