package com.sms.kgnarmaganthirdhomeworkmain.service;



import com.sms.kgnarmaganthirdhomeworkmain.entity.Course;
import com.sms.kgnarmaganthirdhomeworkmain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{

    private final CourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        Iterable<Course> courseIter=repository.findAll();
        List<Course> courseList=new ArrayList<>();
        courseIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        Optional<Course> course=repository.findById(id);

        return course.orElse(null);
    }
    @Transactional(readOnly = true)
    public List<Course> findByCourseNameContaining(String name){
        return repository.findByCourseNameContaining(name);
    }

    @Override
    @Transactional
    public Course save(Course object) {
        return repository.save(object);
    }

    @Override
    @Transactional
    public Course update(Course object) {
        return repository.save(object);
    }

    @Override
    @Transactional
    public void delete(Course object) {
        repository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByCourseName(name);
    }
}
