package com.sms.kgnarmaganthirdhomeworkmain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Gender {

    Male('M'),
    Female('F');

   @Getter
   private char gender;

}
