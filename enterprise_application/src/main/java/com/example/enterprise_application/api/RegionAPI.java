package com.example.enterprise_application.api;

import com.example.enterprise_application.jpa.core.Region;
import com.example.enterprise_application.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/regions")
@RequiredArgsConstructor
public class RegionAPI {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> fillAll(){
        return ResponseEntity.ok(regionService.fillAllRegion());
    }
    @PostMapping
    public ResponseEntity createCountry(@Valid @RequestBody Region region){
        return ResponseEntity.ok(regionService.saveRegion(region));
    }
    @GetMapping("/id")
    public ResponseEntity<Region> findById(@PathVariable Integer id){
        Optional<Region> region = regionService.findById(id);
        if(!region.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(region.get());
    }

    @PutMapping
    public ResponseEntity update(@PathVariable Integer id, @Valid @RequestBody Region newRegion){
        Optional<Region> region = regionService.findById(id);
        if(!region.isPresent()){
            ResponseEntity.badRequest().build();
        }
        regionService.saveRegion(newRegion);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Region> region = regionService.findById(id);
        if(!region.isPresent()){
            ResponseEntity.badRequest().build();
        }
        regionService.deleteRegionById(id);
        return ResponseEntity.ok().build();
    }

}
