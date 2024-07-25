package com.JobApp.JobApp.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService =new JobServiceImpl();

    @GetMapping
    public ResponseEntity<List<Job> >findAll(){
        return  ResponseEntity.ok(jobService.findAll())  ;
    }

    @PostMapping
    public ResponseEntity<String> CreateJob(@RequestBody  Job job ){
        jobService.createJob(job);
        return  new ResponseEntity<>("job added successfully" , HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobByID(@PathVariable Long id ){

        Job job = jobService.getJobByID(id);
        ResponseEntity<Job> jobResponseEntity = job != null ? new ResponseEntity<>(job, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
        return jobResponseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete = jobService.deleteJobByID(id);
        return delete? new ResponseEntity<>("job deleted Successfully",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND)  ;
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> updateJob(@PathVariable Long id
            , @RequestBody Job updateJob){
        boolean updated= jobService.updateJob(id ,updateJob) ;
        return  updated? new ResponseEntity<>("Job Updated Successfuly",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }















}
