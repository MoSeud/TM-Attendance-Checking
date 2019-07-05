package com.redsea.mas.repository;

import com.redsea.mas.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
