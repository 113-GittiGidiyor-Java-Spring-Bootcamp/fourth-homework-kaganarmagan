package com.sms.kgnarmaganthirdhomeworkmain.service;



import com.sms.kgnarmaganthirdhomeworkmain.entity.VisitingResearcher;
import com.sms.kgnarmaganthirdhomeworkmain.repository.VisitingResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitingResearcherService implements BaseService<VisitingResearcher> {
    private final VisitingResearcherRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<VisitingResearcher> findAll() {
        List<VisitingResearcher>researcherList=new ArrayList<>();
        Iterable<VisitingResearcher>researcherIter=repository.findAll();
        researcherIter.iterator().forEachRemaining(researcherList::add);
        return  researcherList;
    }

    @Override
    @Transactional(readOnly = true)
    public VisitingResearcher findById(int id) {
        Optional<VisitingResearcher> visitingResearcher=repository.findById(id);
        return visitingResearcher.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<VisitingResearcher> findBottom3InstructorOrderBySalary() {
        return repository.findTop3ByOrderByHourlySalaryAsc();
    }

    @Transactional(readOnly = true)
    public List<VisitingResearcher> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    @Transactional
    public VisitingResearcher save(VisitingResearcher object) {
        return repository.save(object);
    }

    @Override
    @Transactional
    public VisitingResearcher update(VisitingResearcher object) {
        return repository.save(object);
    }

    @Override
    @Transactional
    public void delete(VisitingResearcher object) {
        repository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
}
