package com.sms.kgnarmaganthirdhomeworkmain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated
    private int ID;
    @NonNull
    private String courseName;
    @NonNull
    private String prefix;
    @NonNull
    private int creditScore;

    @ManyToMany
    private List<Student> students=new ArrayList<>();

    @ManyToOne
    private Instructor instructor;



}
