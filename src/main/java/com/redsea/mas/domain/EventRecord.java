package com.redsea.mas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Table(name = "event_attendance_record")
@Entity
public class EventRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;


    private LocalTime time;
    @NotNull
    private LocalDate date;

    public EventRecord() {

    }

    public EventRecord(@NotNull Event event, @NotNull Student student, @NotNull LocalDate date) {
        this.event = event;
        this.student = student;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
