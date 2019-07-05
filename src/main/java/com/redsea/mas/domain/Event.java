package com.redsea.mas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @NotNull
    @OneToOne
    @JoinColumn(name = "block")
    private Block block;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "event_type")
    private EventType eventType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    @OneToMany(mappedBy = "event",fetch = FetchType.LAZY)
    private List<EventRecord> eventRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<EventRecord> getEventRecords() {
        return eventRecords;
    }

    public void setEventRecords(List<EventRecord> eventRecords) {
        this.eventRecords = eventRecords;
    }
}
