package com.fourthhomework.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentInstructorDTO extends InstructorDTO {
    private double fixedSalary;

}
