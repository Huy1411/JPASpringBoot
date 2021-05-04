package com.example.enterprise_application.service;

import com.example.enterprise_application.jpa.core.Country;
import com.example.enterprise_application.repository.CountryRepository;
import com.example.enterprise_application.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
    private RegionRepository regionRepository;

    public CountryService(CountryRepository countryRepository, RegionRepository regionRepository) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
    }

    public List<Country> fillAllCountry(){
        return countryRepository.findAll();
    }
    public Optional<Country> findById(Integer id){
        return countryRepository.findById(id);
    }


    /** Create a new Country */
    public ResponseEntity<Object> createCountry(Country country) {
        if (countryRepository.findByName(country.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("The Name is already Present, Failed to Create new Country");
        } else {
            Country saveCountry = countryRepository.save(country);
            if (countryRepository.findById(saveCountry.getId()).isPresent())
                return ResponseEntity.ok("Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating Country as Specified");
        }
    }

    /** Update an Existing Country */
    @Transactional
    public ResponseEntity<Object> updateCountry(Country country, Integer id) {
        if(countryRepository.findById(id).isPresent()) {
            Country newCountry = countryRepository.findById(id).get();
            newCountry.setName(country.getName());
            newCountry.setRegion(country.getRegion());
            Country saveCountry = countryRepository.save(newCountry);
            if(countryRepository.findById(saveCountry.getId()).isPresent())
                return  ResponseEntity.accepted().body("Country updated successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed updating the country specified");
        } else return ResponseEntity.unprocessableEntity().body("Cannot find the country specified");
    }

    /** Delete a specified role given the id */
    public ResponseEntity<Object> deleteCountry(Integer id) {
        Optional<Country> country = countryRepository.findById(id);
        if(!country.isPresent()){
            countryRepository.deleteById(id);
            if (countryRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified country");
            }
            else
                return ResponseEntity.ok().body("Successfully deleted the specified country");
        } else
            return ResponseEntity.badRequest().body("Cannot find the country specified");
    }
}
