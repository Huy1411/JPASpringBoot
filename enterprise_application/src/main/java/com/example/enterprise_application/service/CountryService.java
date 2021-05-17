package com.example.enterprise_application.service;

import com.example.enterprise_application.jpa.Country;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {
    List<Country> listCountries();
    Country getCountryById(int country_id);
    boolean saveCountry(Country country);
    boolean updateCountry(Country country);
    boolean deleteCountry(int country_id);
    Page<Country> findPaginated(int pageNo, int pageSize);
}
