package com.fourthhomework.sms.service;





import com.fourthhomework.sms.entity.Student;
import com.fourthhomework.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student>studentList=new ArrayList<>();
        Iterable<Student>studentIter=studentRepository.findAll();
        studentIter.iterator().forEachRemaining(studentList::add);
        return  studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        Optional<Student>student=studentRepository.findById(id);
        return student.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<?> getGendersWithGrouping(){
        return studentRepository.getGendersWithGrouping();
    }

    @Transactional(readOnly = true)
    public List<Student> findStudentsByNameContaining(String name){
        return studentRepository.findByNameContaining(name);
    }

    @Override
    @Transactional
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    @Transactional
    public Student update(Student object) {
        return studentRepository.save(object);
    }

    @Override
    @Transactional
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name){
        studentRepository.deleteByName(name);
    }

}


