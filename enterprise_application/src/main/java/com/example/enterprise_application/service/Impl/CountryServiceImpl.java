package com.example.enterprise_application.service.Impl;

import com.example.enterprise_application.jpa.Country;
import com.example.enterprise_application.repository.CountryRepository;
import com.example.enterprise_application.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> listCountries(){
        try{
            List<Country> list = countryRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Country getCountryById(int country_id) {
        try{
            Country country = countryRepository.findById(country_id).get();
            return country;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCountry(Country country) {
        try{
            countryRepository.save(country);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCountry(Country country) {
        try{
            countryRepository.save(country);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCountry(int country_id) {
        try{
            Country country = countryRepository.findById(country_id).get();
            countryRepository.save(country);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Country> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.countryRepository.findPaginateCountries(pageable);
    }
}
