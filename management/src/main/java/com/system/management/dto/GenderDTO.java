package com.fourthhomework.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GenderDTO {
    Male('M'),
    Female('F');

    @Getter
    private char gender;

}

