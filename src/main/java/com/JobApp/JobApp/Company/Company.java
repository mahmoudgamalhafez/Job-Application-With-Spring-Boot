package com.JobApp.JobApp.Company;

import com.JobApp.JobApp.Job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    public Long getId() {
        return id;
    }

    public Company(Long id, String name, String descreption, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.descreption = descreption;
        this.jobs = jobs;
    }

    public Company() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String descreption ;


    @JsonIgnore
    @OneToMany(mappedBy = "company",fetch = FetchType.EAGER )
    private List<Job> jobs;


   // @OneToMany
  //  private List<Review> reviews;

}
