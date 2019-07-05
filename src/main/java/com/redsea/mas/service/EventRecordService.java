package com.redsea.mas.service;


import com.redsea.mas.domain.EventRecord;
import com.redsea.mas.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EventRecordService {
    List<EventRecord> saveManualRecords(MultipartFile file);
    List<EventRecord> saveAutomaticRecords(MultipartFile file);
    List<EventRecord> findByStudent(Student student);
}
