package com.redsea.mas.serviceImpl;



import com.redsea.mas.domain.Course;
import com.redsea.mas.repository.CourseRepository;
import com.redsea.mas.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseServiceImpl implements CourseService {

    @Autowired
    public CourseRepository courseRepository ;


    @Override
    public List<Course> findAll(){
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long courseId){
        return  courseRepository.findById(courseId).get();

    }
    @Override
    public Course save(Course course){

        return  courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
