package com.example.enterprise_application.api;

import com.example.enterprise_application.jpa.core.Country;
import com.example.enterprise_application.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountryAPI {
    private final CountryService countryService;


    @GetMapping("/all")
    public ResponseEntity<List<Country>> fillAll(){
        return ResponseEntity.ok(countryService.fillAllCountry());
    }
    @PostMapping("/add")
    public ResponseEntity<Object> createCountry(@Valid @RequestBody Country country) {
        return  countryService.createCountry(country);
    }
    @GetMapping("/details/id")
    public ResponseEntity<Country> findById(@PathVariable Integer id){
        Optional<Country> country = countryService.findById(id);
        if(!country.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(country.get());
    }
    @PutMapping("/update/id")
    public ResponseEntity<Object> updateCountry(@PathVariable Integer id, @Valid @RequestBody Country country) {
        return countryService.updateCountry(country, id);
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        return countryService.deleteCountry(id);
    }

}
