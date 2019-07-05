package com.redsea.mas.repository;

import com.redsea.mas.domain.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, Long> {

    EventType findByName(String name);

    EventType findByShortName(String shortName);

}
