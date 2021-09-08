package com.fourthhomework.sms.service;


import com.fourthhomework.sms.entity.PermanentInstructor;
import com.fourthhomework.sms.repository.PermanentInstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermanentInstructorService implements BaseService<PermanentInstructor>{
    private final PermanentInstructorRepository repository;

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

    @Override
    @Transactional
    public PermanentInstructor save(PermanentInstructor object) {
        return repository.save(object);
    }

    @Override
    @Transactional
    public PermanentInstructor update(PermanentInstructor object) {
        return repository.save(object);
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
