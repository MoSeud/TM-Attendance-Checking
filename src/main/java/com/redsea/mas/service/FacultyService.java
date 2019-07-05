package com.redsea.mas.service;



import com.redsea.mas.domain.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Faculty save(Faculty faculty);
    Faculty findByEmail(String email);
    Faculty findById(Long id);
    void delete(Faculty faculty);
    void deleteById(Long id);
   List<Faculty> findFirstTen();
}
