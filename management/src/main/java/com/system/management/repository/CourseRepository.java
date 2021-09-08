package com.fourthhomework.sms.repository;


import com.fourthhomework.sms.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    List<Course> findByCourseNameContaining(String name);
    void deleteByCourseName(String name);
}
