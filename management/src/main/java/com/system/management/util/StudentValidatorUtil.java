package com.system.management.util;

import java.time.LocalDate;
import java.time.Period;

public class StudentValidatorUtil {
    public static void validateStudentAge(LocalDate birthDate) {
        if(Period.between(LocalDate.now(),birthDate).getYears()<18|);
    }
}
