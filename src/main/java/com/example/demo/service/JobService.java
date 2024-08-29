package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Applied;
import com.example.demo.model.JobPost;
import com.example.demo.repository.JobsRepo;

@Service
public class JobService {

	@Autowired
	private JobsRepo repo;
	
	public List<JobPost> retrieveData() {
		
		return repo.findAll();
	}

	public void addData(JobPost jobpost) {
		
		repo.addJobs(jobpost);
	}


	public JobPost getJobById(int id) {
		Optional<JobPost> job = repo.findById(id);
        if (job.isPresent()) {
            return job.get();
        } else {
            throw new RuntimeException("Job not found for id: " + id);
        }
	}

	public void addDataSubmission(Applied applied) {
		
		repo.addJobsSubmit(applied);
		
	}

	

	public List<Applied> getAppliedJob() {
		return repo.getAppliedData();
	}

}
