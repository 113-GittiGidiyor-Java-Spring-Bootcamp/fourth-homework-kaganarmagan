package com.sms.kgnarmaganthirdhomeworkmain.repository;


import com.sms.kgnarmaganthirdhomeworkmain.entity.PermanentInstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermanentInstructorRepository extends CrudRepository<PermanentInstructor,Integer> {
    List<PermanentInstructor> findByNameContaining(String name);// Specialized methods which are asked --- search a object with its name or just some part of its name
    void deleteByName(String name);//                                                                  --- delete object using its name

    List<PermanentInstructor> findTop3ByOrderByFixedSalaryDesc();//                                    --- find top 3 highest salary
}
