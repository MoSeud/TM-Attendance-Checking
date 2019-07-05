package com.redsea.mas.service;


import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Event;
import com.redsea.mas.domain.EventType;
import com.redsea.mas.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {
    Event save(Event event);
    Event findById(Long id);
    void delete(Long id);

    List<Event> findAll();
    Event findByBlock(Block block);
    List<Event> findByType(EventType type);
    Event findByBlockAndType(Block block, EventType type);
    Event findByBlockAndTypeAndLocation(Block block, EventType eventType, Location location);

}
