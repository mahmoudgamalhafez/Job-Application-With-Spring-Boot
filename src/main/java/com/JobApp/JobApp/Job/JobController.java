package com.JobApp.JobApp.Job;

import com.JobApp.JobApp.Job.Imp.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

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
