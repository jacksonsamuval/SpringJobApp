package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.JobPost;

@Repository
public class JobsRepo {

	public List<JobPost> jobs = new ArrayList<>(Arrays.asList(
			
			new JobPost(1,"python dev","good boy",5, List.of("python","swift")),
			new JobPost(2,"java dev","good boy",2, List.of("java","swift"))
			));
	

	
	public void addJobs(JobPost jobpost) {
		
		jobs.add(jobpost);
		System.out.println(jobs);
	}

	public List<JobPost> findAll() {
		
		return jobs;
	}
	
	

}
