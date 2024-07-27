package com.JobApp.JobApp.Job.Imp;

import com.JobApp.JobApp.Job.Job;
import com.JobApp.JobApp.Job.JobRepository;
import com.JobApp.JobApp.Job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    //    private List<Job> jobs = new ArrayList<>();

   private final JobRepository jobRepository ;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }

    public Job getJobByID(Long id){
        return  jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobByID(Long id) {
        try {
            jobRepository.deleteById(id);
            return  true ;
        }catch (Exception e){
            return  false ;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional =jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setId(updateJob.getId());
                job.setDescription(updateJob.getDescription());
                job.setLocation(updateJob.getLocation());
                job.setTitle(updateJob.getTitle());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setMinSalary(updateJob.getMinSalary());
                jobRepository.save(job);
                return true ;
            }
        return false;
    }


}
