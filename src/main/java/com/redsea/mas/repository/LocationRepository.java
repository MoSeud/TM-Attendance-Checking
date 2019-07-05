package com.redsea.mas.repository;

import com.redsea.mas.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends CrudRepository<Location,Long> {
    Location findByShortName(String shortName);
}
