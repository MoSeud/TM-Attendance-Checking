package com.redsea.mas.repository;

import com.redsea.mas.domain.EventRecord;
import com.redsea.mas.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRecordRepository extends CrudRepository<EventRecord,Long> {
    List<EventRecord> findAllByStudent(Student student);
    List<EventRecord> findAll();

}
