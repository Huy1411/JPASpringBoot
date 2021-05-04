package com.example.enterprise_application.service;

import com.example.enterprise_application.jpa.core.Region;
import com.example.enterprise_application.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    public List<Region> fillAllRegion(){
        return regionRepository.findAll();
    }
    public Optional<Region> findById(Integer id){
        return regionRepository.findById(id);
    }

    public Region saveRegion(Region region){
        return regionRepository.save(region);
    }
    public void deleteRegionById(Integer id){
        regionRepository.deleteById(id);
    }
}
