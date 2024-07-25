package com.JobApp.JobApp.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    public Job getJobByID(Long id );

    boolean deleteJobByID(Long id);

    boolean updateJob(Long id, Job updateJob);
}
