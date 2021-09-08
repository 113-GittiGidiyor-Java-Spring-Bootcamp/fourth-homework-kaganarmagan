package com.fourthhomework.sms.dto;

import com.fourthhomework.sms.entity.Instructor;
import com.fourthhomework.sms.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private int ID;
    private String courseName;
    private String prefix;
    private int creditScore;
    private List<StudentDTO> students;
    private InstructorDTO instructor;

}
