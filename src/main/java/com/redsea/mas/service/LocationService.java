package com.redsea.mas.service;



import com.redsea.mas.domain.Location;

import java.util.List;

public interface LocationService {

    List<Location> findAll();
    Location findById(Long locationId);
    Location save(Location location);
    void updateLocation(Location location);
    void delete(Location location);
    Location findByShortName(String shortName);

}
