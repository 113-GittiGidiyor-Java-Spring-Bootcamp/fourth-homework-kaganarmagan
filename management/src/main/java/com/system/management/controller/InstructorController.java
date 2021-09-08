package com.fourthhomework.sms.controller;



import com.fourthhomework.sms.entity.PermanentInstructor;
import com.fourthhomework.sms.entity.VisitingResearcher;
import  com.fourthhomework.sms.service.PermanentInstructorService;
import  com.fourthhomework.sms.service.VisitingResearcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final PermanentInstructorService permanentInstructorService;
    private final VisitingResearcherService visitingResearcherService;

    @Autowired
    private  RestTemplate restTemplate;
    // coded individually for all types of instructors

//permenants  instructor methods
    @GetMapping("/permanent")
    public ResponseEntity<List<PermanentInstructor>> findPermanentInstructors(@RequestParam(required = false,defaultValue = "")String name){
        if(name.length()!=0){
            return new ResponseEntity<>(permanentInstructorService.findByNameContaining(name),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(permanentInstructorService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/permanent/{id}")
    public ResponseEntity<PermanentInstructor> findPermanentInstructorById(@PathVariable int id){
        return new ResponseEntity<>(permanentInstructorService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/permanent")
    public ResponseEntity<PermanentInstructor> savePermanentInstructor(@RequestBody PermanentInstructor permenantInstructor){
        return new ResponseEntity<>(permanentInstructorService.save(permenantInstructor),HttpStatus.CREATED);
    }

    @PutMapping("/permanent")
    public ResponseEntity<PermanentInstructor> updatePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        return new ResponseEntity<>(permanentInstructorService.update(permanentInstructor),HttpStatus.OK);
    }

    @DeleteMapping("/permanent/{id}")
    public ResponseEntity<String> deletePermanentInstructorById(@PathVariable int id){
        permanentInstructorService.deleteById(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @DeleteMapping("/permanent")
    public ResponseEntity<String> deletePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        permanentInstructorService.delete(permanentInstructor);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @DeleteMapping("/permanent/name/{name}")
    public ResponseEntity<String> deletePermanentInstructorByName(@PathVariable String name){
        permanentInstructorService.deleteBYName(name);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
    @GetMapping("/permanent/dollar/{id}")
    public ResponseEntity<String> getPermanentInstructorSalaryAsDollar(@PathVariable int id){
        PermanentInstructor permanentInstructor=permanentInstructorService.findById(id);
        String salary=null;
        try {
            salary=restTemplate.getForObject("http://localhost:8081/api/dollar/"+permanentInstructor.getFixedSalary(),String.class);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        String responseString= "Permanent instructor "+permanentInstructor.getName()+" earns hourly "+salary+" $";
        return new ResponseEntity<>(responseString,HttpStatus.OK);// example of currency change on salary of a visiting researcher
    }
//# Permenant Instructor
    //visiting researcher methods
    @GetMapping("/visiting")
    public ResponseEntity<List<VisitingResearcher>> findVisitingResearchers(@RequestParam(required = false,defaultValue = "") String name){
        if(name.length()!=0){
            return new ResponseEntity<>(visitingResearcherService.findByNameContaining(name),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(visitingResearcherService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/visiting/{id}")
    public ResponseEntity<VisitingResearcher> findVisitingResearcherById(@PathVariable int id){
        return new ResponseEntity<>(visitingResearcherService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/visiting")
    public ResponseEntity<VisitingResearcher> saveVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        return new ResponseEntity<>(visitingResearcherService.save(visitingResearcher),HttpStatus.CREATED);
    }

    @PutMapping("/visiting")
    public ResponseEntity<VisitingResearcher> updateVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        return new ResponseEntity<>(visitingResearcherService.update(visitingResearcher),HttpStatus.OK);
    }

    @DeleteMapping("/visiting/{id}")
    public ResponseEntity<String> deleteVisitingResearcherById(@PathVariable int id){
        visitingResearcherService.deleteById(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @DeleteMapping("/visiting")
    public ResponseEntity<String> deleteVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        visitingResearcherService.delete(visitingResearcher);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @DeleteMapping("/visiting/name/{name}")
    public ResponseEntity<String> deleteVisitingResearcherByName(@PathVariable String name){
        visitingResearcherService.deleteByName(name);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }

    @GetMapping("/salary/top")
    public ResponseEntity<List<PermanentInstructor>> getTop3InstructorOrderBySalary(){
        return new ResponseEntity<>(permanentInstructorService.findTop3ByOrderByFixedSalaryDesc(),HttpStatus.OK);
    }
    @GetMapping("/salary/bottom")
    public ResponseEntity<List<VisitingResearcher>> getBottom3InstructorOrderBySalary(){
        return new ResponseEntity<>(visitingResearcherService.findBottom3InstructorOrderBySalary(),HttpStatus.OK);
    }


}
