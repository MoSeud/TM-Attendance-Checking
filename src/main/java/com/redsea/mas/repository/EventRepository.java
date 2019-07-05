package com.redsea.mas.repository;

import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Event;
import com.redsea.mas.domain.EventType;
import com.redsea.mas.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
    Event findByBlock(Block block);
    List<Event> findAllByEventType(EventType type);
    Event findByBlockAndEventType(Block block, EventType eventType);
    Event findByBlockAndEventTypeAndLocation(Block block, EventType eventType, Location location);
}
