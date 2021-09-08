package com.sms.kgnarmaganthirdhomeworkmain.repository;


import com.sms.kgnarmaganthirdhomeworkmain.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    List<Course> findByCourseNameContaining(String name);
    void deleteByCourseName(String name);
}
