package com.redsea.mas.service;


import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Student;
import com.redsea.mas.models.BlockAttendance;
import com.redsea.mas.models.CumulativeAttendance;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AttendanceService {
    BlockAttendance getBlockAttendance(Student student, Block block);
    List<BlockAttendance> getAllStudentAttendance(List<Student> students,Block block);
    CumulativeAttendance getStudentCumulative(Student student);
    List<CumulativeAttendance> getByEntry(List<Student> students);
    Map<String,Boolean> getBlockAttendanceDateList(Student student, Block block);
}
