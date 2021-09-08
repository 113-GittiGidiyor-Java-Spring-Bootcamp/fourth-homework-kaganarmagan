package com.fourthhomework.sms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentDTO {
    private int ID;
    private LocalDate birthDate;
    private GenderDTO gender;
    private String name;
    private String address;
    private List<CourseDTO> courseList;

}
