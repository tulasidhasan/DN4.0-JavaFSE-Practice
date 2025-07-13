package com.cognizant.spring_learn2.controller;

import com.cognizant.spring_learn2.model.Country;
import com.cognizant.spring_learn2.service.CountryService;
import com.cognizant.spring_learn2.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (Country) context.getBean("in");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return service.getAllCountries();
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return service.getCountry(code);
    }
}
