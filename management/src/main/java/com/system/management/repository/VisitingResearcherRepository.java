package com.fourthhomework.sms.repository;



import com.fourthhomework.sms.entity.VisitingResearcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitingResearcherRepository extends CrudRepository<VisitingResearcher,Integer> {
    List<VisitingResearcher> findByNameContaining(String name);
    void deleteByName(String name);
    List<VisitingResearcher> findTop3ByOrderByHourlySalaryAsc();
}
