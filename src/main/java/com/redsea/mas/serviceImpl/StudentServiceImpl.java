package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Phone;
import com.redsea.mas.domain.Student;
import com.redsea.mas.repository.PhoneRepository;
import com.redsea.mas.repository.StudentRepository;
import com.redsea.mas.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student findStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student findStudentByBarcode(String barCode) {
        return studentRepository.findByBarCode(barCode);
    }

    @Override
    public Student findStudentByEntry(LocalDate entry) {
        return studentRepository.findTopByEntry(entry);
    }

    @Override
    public List<Student> findStudentsByEntry(LocalDate entry) {
        return studentRepository.findByEntry(entry);
    }

    @Override
    public Student save(Student student) {
        Phone phone=phoneRepository.save(student.getPhone());
        student.setPhone(phone);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getFirstTen() {
        return studentRepository.getFirstTen();
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteByStudentId(String studentId) {

        studentRepository.deleteByStudentId(studentId);
    }

    @Override
    public List<Student> findByEntry(LocalDate localDate) {
        return studentRepository.findStudentByEntryAfter(localDate);
    }
}
