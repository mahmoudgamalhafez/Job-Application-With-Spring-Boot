package com.JobApp.JobApp.Job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId= 1L;


    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);

    }

    public Job getJobByID(Long id ){

        Job job =jobs.stream().filter(job_-> job_.getId()==id).findFirst().orElse(null);
        return job ;
    }

    @Override
    public boolean deleteJobByID(Long id) {
        boolean isRemoved = jobs.removeIf(job -> job.getId()== id ) ;
        return isRemoved;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        for(Job job : jobs){
            if(job.getId()==updateJob.getId()){
                job.setId(updateJob.getId());
                job.setDescription(updateJob.getDescription());
                job.setLocation(updateJob.getLocation());
                job.setTitle(updateJob.getTitle());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setMinSalary(updateJob.getMinSalary());
                return true ;
            }
        }
        return false;
    }





}
