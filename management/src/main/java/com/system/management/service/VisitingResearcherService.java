package com.system.management.service;





import com.system.management.dto.VisitingResearcherDTO;
import com.system.management.entity.VisitingResearcher;
import com.system.management.exceptions.InstructorAlreadyExistsException;
import com.system.management.mappers.VisitingResearcherMapper;
import com.system.management.repository.InstructorRepository;
import com.system.management.repository.VisitingResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitingResearcherService implements BaseService<VisitingResearcher> {
    @Autowired
    private VisitingResearcherRepository repository;
    @Autowired
    private  VisitingResearcherMapper mapper;
    @Autowired
    private InstructorRepository instructorRepository;
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


    @Transactional
    public VisitingResearcher save(VisitingResearcherDTO object) {
        if(instructorRepository.existsInstructorByPhoneNumber(object.getPhoneNumber())){
            throw new InstructorAlreadyExistsException("Phone number already is used by a Instructor");
        }

        VisitingResearcher visitingResearcher=mapper.mapFromVisitingResearcherDTOtoVisitingResearcher(object);
        return repository.save(visitingResearcher);
    }


    @Transactional
    public VisitingResearcher update(VisitingResearcherDTO object) {
        if(instructorRepository.existsInstructorByPhoneNumber(object.getPhoneNumber())){
            throw new InstructorAlreadyExistsException("Phone number already is used by a Instructor");
        }
        VisitingResearcher visitingResearcher=mapper.mapFromVisitingResearcherDTOtoVisitingResearcher(object);

        return repository.save(visitingResearcher);
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
