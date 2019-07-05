package com.redsea.mas.service;



import com.redsea.mas.domain.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {


    Student findById(Long id);
    Student findByFirstName(String firstName);
    Student findStudentByStudentId(String studentId);
    List<Student> getAllStudents();
    Student findStudentByEmail(String email);
    Student findStudentByBarcode(String barCode);
    Student findStudentByEntry(LocalDate entry);
    List<Student> findStudentsByEntry(LocalDate entry);
    Student save(Student student);
    List<Student> getFirstTen();
   void delete(Student student);
   void deleteById(Long id);
   void deleteByStudentId(String studentId);
   List<Student>findByEntry(LocalDate localDate);
}
