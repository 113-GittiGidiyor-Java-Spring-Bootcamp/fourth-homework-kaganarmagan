package com.system.management.service;



import com.system.management.dto.PermanentInstructorDTO;
import com.system.management.entity.PermanentInstructor;
import com.system.management.exceptions.InstructorAlreadyExistsException;
import com.system.management.mappers.PermanentInstructorMapper;
import com.system.management.repository.InstructorRepository;
import com.system.management.repository.PermanentInstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermanentInstructorService implements BaseService<PermanentInstructor> {
    @Autowired
    private  PermanentInstructorRepository repository;
    @Autowired
    private  PermanentInstructorMapper mapper;
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PermanentInstructor> findAll() {
        List<PermanentInstructor> permanentInstructors=new ArrayList<>();
        Iterable<PermanentInstructor> permanentIter=repository.findAll();
        permanentIter.iterator().forEachRemaining(permanentInstructors::add);
        return permanentInstructors;
    }

    @Override
    @Transactional(readOnly = true)
    public PermanentInstructor findById(int id) {
        Optional<PermanentInstructor> permanentInstructor=repository.findById(id);
        return permanentInstructor.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<PermanentInstructor> findByNameContaining(String name){
        return repository.findByNameContaining(name);
    }
    @Transactional(readOnly = true)
    public List<PermanentInstructor> findTop3ByOrderByFixedSalaryDesc(){
        return repository.findTop3ByOrderByFixedSalaryDesc();
    }


    @Transactional
    public PermanentInstructor save(PermanentInstructorDTO object) {

        if(instructorRepository.existsInstructorByPhoneNumber(object.getPhoneNumber())){
            throw new InstructorAlreadyExistsException("Phone number already is used by a Instructor");
        }
        PermanentInstructor permanentInstructor= mapper.mapFromPermanentInstructorDTOtoPermanentInstructor(object);
        return repository.save(permanentInstructor);
    }


    @Transactional
    public PermanentInstructor update(PermanentInstructorDTO object) {
        if(instructorRepository.existsInstructorByPhoneNumber(object.getPhoneNumber())){
            throw new InstructorAlreadyExistsException("Phone number already is used by a Instructor");
        }
       PermanentInstructor permanentInstructor= mapper.mapFromPermanentInstructorDTOtoPermanentInstructor(object);
        return repository.save(permanentInstructor);
    }

    @Override
    @Transactional
    public void delete(PermanentInstructor object) {
        repository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteBYName(String name){
        repository.deleteByName(name);
    }

}
