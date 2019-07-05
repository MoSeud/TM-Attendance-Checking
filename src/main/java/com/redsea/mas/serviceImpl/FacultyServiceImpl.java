package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Faculty;
import com.redsea.mas.repository.FacultyRepository;
import com.redsea.mas.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return (List<Faculty>) facultyRepository.findAll();
    }

    @Override
    public Faculty save(Faculty faculty) {
        return  facultyRepository.save(faculty);
    }

    @Override
    public Faculty findByEmail(String email) {
        return facultyRepository.findByEmail(email);
    }

    @Override
    public Faculty findById(Long id) {
        return (Faculty) facultyRepository.findById(id).get();
    }

    @Override
    public void delete(Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    @Override
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> findFirstTen() {
        return facultyRepository.getFirstTen();
    }
/*
    @Override
    public List<Faculty> findAll() {
        return (List<Faculty>) facultyRepository.findAll();
    }*/
}
