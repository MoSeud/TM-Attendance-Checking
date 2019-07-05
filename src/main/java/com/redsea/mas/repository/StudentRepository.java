package com.redsea.mas.repository;


import com.redsea.mas.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    Student findByEmail(String email);
    Student findByStudentId(String studentId);
    Student findByBarCode(String barcode);
    List<Student> findByEntry(LocalDate entry);
    Student findTopByEntry(LocalDate entry);
    Student findAllByEntry(LocalDate entry);
    void deleteByStudentId(String studentId);
    Student findByFirstName(String firstName);
    @Query(value = "select * from student limit 10",nativeQuery = true)
    List<Student> getFirstTen();

    List<Student> findStudentByEntryAfter(LocalDate l);

    List<Student> findAllByEntryAfter(LocalDate localDate);



}
