package com.redsea.mas.service;


import com.redsea.mas.domain.EventType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventTypeService {
    EventType findById(Long id);
    EventType save(EventType eventType);
    void delete(Long id);
    List<EventType> findAll();
    EventType findByShortName(String shortName);
}
