package com.cognizant.orm_learn.service;


import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional
    public Country findCountryById(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    @Transactional
public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
    Optional<Country> result = countryRepository.findById(countryCode);
    if (!result.isPresent()) {
        throw new CountryNotFoundException("Country code not found: " + countryCode);
    }
    return result.get();
}



  @Transactional
public void updateCountry(String code, String name) throws CountryNotFoundException {
    Optional<Country> optional = countryRepository.findById(code);
    if (!optional.isPresent()) {
        throw new CountryNotFoundException("Country not found for code: " + code);
    }

    Country country = optional.get();
    country.setName(name);
    countryRepository.save(country);
}

    
    

}