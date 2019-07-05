package com.redsea.mas.service;


import com.redsea.mas.domain.Course;
import org.springframework.stereotype.Service;


import java.util.List;

public interface CourseService {
   // @RolesAllowed("ADMIN")
    List<Course> findAll();
    Course findById(Long courseId);
    Course save(Course course);
    void delete(Long id);

}
