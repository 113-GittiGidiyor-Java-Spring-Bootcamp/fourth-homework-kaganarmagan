package com.system.management.mappers;

import com.system.management.dto.StudentDTO;
import com.system.management.entity.Student;
import com.system.management.service.StudentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    @Autowired
    StudentService studentService;

    @Mapping(target="courseList",expression = "java(studentService.findCoursesById(studentDTO.getCourseIds()))")
    public abstract  Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);

    @Mapping(target="courseIds",expression = "java(studentService.findCoursesId(student.getCourseList()))")
    public abstract StudentDTO mapFromStudentToStudentDTO(Student student);

}
