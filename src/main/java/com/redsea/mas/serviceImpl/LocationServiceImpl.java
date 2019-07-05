package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Location;
import com.redsea.mas.repository.LocationRepository;
import com.redsea.mas.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public List<Location> findAll(){
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public Location findById( Long locationId){
        return  locationRepository.findById(locationId).get();

    }
    @Override
    public Location save(Location location){

        return  locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }

    public Location findByShortName(String shortName) {
        return locationRepository.findByShortName(shortName);
    }

}
