package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Event;
import com.redsea.mas.domain.EventType;
import com.redsea.mas.domain.Location;
import com.redsea.mas.repository.EventRepository;
import com.redsea.mas.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
    eventRepository.deleteById(id);
    }


    @Override
    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event findByBlock(Block block) {
        return eventRepository.findByBlock(block);
    }

    @Override
    public List<Event> findByType(EventType type) {
        return eventRepository.findAllByEventType(type);
    }

    @Override
    public Event findByBlockAndType(Block block, EventType type) {
        return eventRepository.findByBlockAndEventType(block,type);
    }

    @Override
    public Event findByBlockAndTypeAndLocation(Block block, EventType eventType, Location location) {
        return eventRepository.findByBlockAndEventTypeAndLocation(block,eventType,location);
    }
}
